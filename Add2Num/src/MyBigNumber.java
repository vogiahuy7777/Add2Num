
/**
 *
 * @author Hy's  PC
 */
public class MyBigNumber {

    private IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }

    /**
     * Hàm dùng để cộng 2 số. Trong đó đưa vào 2 chuỗi số chỉ chứ kí tự từ 0-9.
     *
     * @param str1 chuỗi số thứ nhất.
     * @param str2 chuỗi số thứ hai.
     */
    public String sum(final String str1, final String str2) {
        String num1 = str1;
        String num2 = str2;
        String step = "";
        String process = "";
        String sum = "";//tao ra biến lưu kết quả
        final String pattern = "\\d+"; // Chuỗi đại diện cho kí tự số từ [0-9]
        final boolean isError1;// biến để lưu dữ kết quả xét chuỗi s1 
        final boolean isError2;// biến để lưu dữ kết quả xét chuỗi s2

        int i = 1;//biến đếm cho vòng lặp
        int remember = 0;//tạo ra biến lưu số để nhớ nếu kết quả cộng lớn hơn 10
        int numSum = 0; // biến dùng để lưu kết qua phép cộng của từng kì tụ trong chuỗi

        char char1 = '0';
        char char2 = '0';
        
        // bắt lỗi dữ liệu nhập vào nếu có
        try {
            //kiểm tra người dùng có nhập đủ input ch
            if (num1.equals("")) {
                this.ireceiver.send("Plese enter  the Fisrt Number: ");
                throw new NumberFormatException("Plese enter number  the Fisrt Number");
            }

            if (num2.equals("")) {
                this.ireceiver.send("Plese enter  the Second Number: ");
                throw new NumberFormatException("Plese enter number  the Second Number");
            }

            // Kiểm tra số âm
            if (num1.charAt(0) == '-') {
                this.ireceiver.send("Plese enter number isn't negative in the Fisrt Number: " + num1);
                throw new NumberFormatException("Plese enter number isn't negative in the Fisrt Number: " + num1);
            }

            if (num2.charAt(0) == '-') {
                ireceiver.send("Plese enter number isn't negative in Second Number: " + num2);
                throw new NumberFormatException("Plese enter number isn't negative in the Fisrt Number: " + num2);
            }

            // Kiểm tra kí tự đặc biệt
            isError1 = str1.matches(pattern);
            isError2 = str2.matches(pattern);

            if (!isError1) {
                this.ireceiver.send("Please enter number do not contain symbol in Second Number : " + num1);
                throw new NumberFormatException("Please enter number do not contain symbol in Fisrt Number : " + num1);
            }

            if (!isError2) {
                this.ireceiver.send("Please enter number do not contain symbol in Second Number : " + num2);
                throw new NumberFormatException("Please enter number do not contain symbol in Second Number : " + num2);

            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            
            return "error";
        }

        //so sánh tìm số có nhiều chử số hơn
        if (num1.length() < num2.length()) // nếu chuỗi nào có độ dài lớn hơn ta sẽ chạy số lần lặp theo chuỗi đó
        {

            // tiến hành swap chuỗi nếu chuỗi 2 lớn hơn chuỗi 1
            String item = num2;
            num2 = num1;
            num1 = item;
            step = "Fisrt step we swap first number and second number: \n"
                    + "  + Fisrt number is: " + num1 + "\n"
                    + "  + Second number is: " + num2 + "\n";
        }

        for (i = 1; i <= num1.length(); i++) { // chạy vòng lặp để tham chiếu đến từng kí tự của chuổi
            char1 = num1.charAt(num1.length() - i);

            //kiểm tra xem đã xét hêt chuỗi thứ 2 đã hết chưa
            if (num2.length() - i >= 0) {
                char2 = num2.charAt(num2.length() - i);
                numSum = char1 - '0' + char2 - '0' + remember; //công từng kí tự của chuỗi 1 và chuỗi 2 và phần nhớ nếu có
            } else {
                numSum = char1 - '0' + remember; //cộng kí tự chuổi 1 và phần nhớ ki đã xét hết kí tự trong chuỗi 2
            }
            sum = Integer.toString(numSum % 10) + sum; //ghi kết quả cộng vào biến kết quả

            //lưu phần nhớ là 1 nếu kết quả cộng lớn hơn 10 
            if (numSum >= 10) {

                // kiểm tra nếu có phần nhớ thì in ra bước cộng có cộng phần nhớ nếu không thì cộng theo bình thường
                if (remember == 1) {
                    process = "Step " + i + ": " + char1 + " + " + char2 + " + " + remember + " = " + numSum;
                } else {
                    process = "Step " + i + ": " + char1 + " + " + char2 + " = " + numSum;
                }
                remember = 1;
                process = process + ", remember " + remember + ", write "
                        + (numSum % 10) + " current result: " + sum + "\n";

            } else {

                // kiểm tra nếu có phần nhớ thì in ra bước cộng có cộng phần nhớ nếu không thì cộng theo bình thường
                if (remember == 1) {
                    process = "Step " + i + ": " + char1 + " + " + char2 + " + " + remember + " = " + numSum;
                } else {
                    process = "Step " + i + ": " + char1 + " + " + char2 + " = " + numSum;
                }
                remember = 0;
                process = process + ", write " + (numSum % 10) + " current result: " + sum + "\n";
            }
            step = step + process;

        }

        // ghi phần nhớ vào nếu phép cộng vượt số
        // VD 999+99=1098
        if (remember == 1) {
            sum = Integer.toString(remember) + sum;
            step = step + "Step " + i + ": " + "Because we still remember 1, We write 1 before result \n";
        }

        this.ireceiver.send(step);// gửi các bước đến ireceiver để in ra màn hình

        // trả về kết quả của phép cộng
        return sum;
    }
}
