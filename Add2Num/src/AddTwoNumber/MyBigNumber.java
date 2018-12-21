package AddTwoNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hy's PC
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
        int pos;
        String num1 = str1;
        String num2 = str2;
        String step = "";
        String process = "";
        String sum = "";//tao ra biến lưu kết quả
        Pattern pattern = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher isError1 = pattern.matcher(num1);// biến để lưu dữ kết quả xét chuỗi s1 
        final Matcher isError2 = pattern.matcher(num2);;// biến để lưu dữ kết quả xét chuỗi s2

        int i = 1;//biến đếm cho vòng lặp
        int remember = 0;//tạo ra biến lưu số để nhớ nếu kết quả cộng lớn hơn 10
        int numSum = 0; // biến dùng để lưu kết qua phép cộng của từng kì tụ trong chuỗi

        char char1 = '0';
        char char2 = '0';

        // bắt lỗi dữ liệu nhập vào nếu có
        //kiểm tra người dùng có nhập đủ input ch
        if (num1.equals("")) {
            this.ireceiver.send("Vui lòng nhập số thứ nhất: ");
            throw new NumberFormatException("Vui lòng nhập số thứ nhất");
        }

        if (num2.equals("")) {
            this.ireceiver.send("Vui lòng nhập số thứ 2: ");
            throw new NumberFormatException("Vui lòng nhập số thứ 2");
        }

        // Kiểm tra số âm
        if (num1.charAt(0) == '-') {
            this.ireceiver.send("không hổ trợ số âm: " + num1);
            throw new NumberFormatException("Không hổ trợ số âm: " + num1);
        }

        if (num2.charAt(0) == '-') {
            ireceiver.send("Không hổ trợ số âm: " + num2);
            throw new NumberFormatException("Không hổ trợ số âm: " + num2);
        }

        // Kiểm tra kí tự đặc biệt
        if (isError1.find()) {
            pos = isError1.start() + 1;
            this.ireceiver.send("Vị trí " + pos + "trong chuổi " + num1 + " không phải là số");
            throw new NumberFormatException(pos + "");
        }

        if (isError2.find()) {
            pos = isError2.start() + 1;
            this.ireceiver.send("Vị trí " + pos + "trong chuổi " + num2 + " không phải là số");
            throw new NumberFormatException(pos + "");

        }

        //so sánh tìm số có nhiều chử số hơn
        if (num1.length() < num2.length()) // nếu chuỗi nào có độ dài lớn hơn ta sẽ chạy số lần lặp theo chuỗi đó
        {

            // tiến hành swap chuỗi nếu chuỗi 2 lớn hơn chuỗi 1
            String item = num2;
            num2 = num1;
            num1 = item;
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
            remember = numSum / 10;

            // kiểm tra xem có phần nhớ hay không
            if (remember == 1) {
                if (num2.length() - i >= 0) {
                    process = "bước " + i + ", lấy " + char1 + " cộng " + char2 + " cộng " + remember + " được " + numSum + ", ghi " + numSum % 10 + ", nhớ " + remember + "\n";
                } else {
                    process = "bước " + i + ", lấy " + char1 + " cộng " + remember + " được " + numSum + ", ghi " + numSum % 10 + ", nhớ " + remember + "\n";
                }
            } else {
                if (num2.length() - i >= 0) {
                    process = "bước " + i + ", lấy " + char1 + " cộng " + char2 + " được " + numSum + ", ghi " + numSum % 10 + "\n";
                } else {
                    process = "bước " + i + ", lấy " + char1 + " cộng 0" + " được " + numSum + ", ghi " + numSum % 10 + "\n";
                }
            }

            step = step + process;
        }

        // ghi phần nhớ vào nếu phép cộng vượt số
        // VD 999+99=1098
        if (remember == 1) {
            sum = Integer.toString(remember) + sum;
            step = step + "bước " + i + ", lấy " + remember + " ghi trước kết quả";
        }

        this.ireceiver.send(step);// gửi các bước đến ireceiver để in ra màn hình

        // trả về kết quả của phép cộng
        return sum;
    }
}
