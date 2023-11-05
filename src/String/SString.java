package String;

public class SString {
    private final char[] value;

    // 构造方法
    public SString(char[] value) {
        this.value = value;
    }

    // 主方法用于测试
    public static void main(String[] args) {
        char[] chars = "Hello, Custom SString!".toCharArray();
        SString myString = new SString(chars);

        // 使用自定义方法
        int length = myString.length();
        System.out.println("Length: " + length);

        char[] otherChars = " How are you?".toCharArray();
        SString otherString = new SString(otherChars);
        SString concatenatedString = myString.concat(otherString);
        System.out.println("Concatenated String: " + new String(concatenatedString.getValue()));

        SString substring = myString.substring(7, 13);
        System.out.println("Substring: " + new String(substring.getValue()));

        // 测试 charAt 方法
        char character = myString.charAt(1);
        System.out.println("Character at index 1: " + character);
    }

    // 获取字符串长度的方法
    public int length() {
        return value.length;
    }

    // 获取字符串的方法
    public char[] getValue() {
        return value;
    }

    // 获取指定位置的字符
    public char charAt(int index) {
        if (index < 0 || index >= value.length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + value.length);
        }
        return value[index];
    }

    // 连接字符串的方法
    public SString concat(SString other) {
        char[] result = new char[this.value.length + other.length()];
        System.arraycopy(this.value, 0, result, 0, this.value.length);
        System.arraycopy(other.getValue(), 0, result, this.value.length, other.length());
        return new SString(result);
    }

    // 截取子串的方法
    public SString substring(int start, int end) {
        char[] result = new char[end - start];
        System.arraycopy(value, start, result, 0, end - start);
        return new SString(result);
    }

    public int compareTo(SString other) {
        int len1 = this.value.length;
        int len2 = other.length();
        int minLength = Math.min(len1, len2);

        // 比较每个字符
        for (int i = 0; i < minLength; i++) {
            char c1 = this.value[i];
            char c2 = other.charAt(i);

            if (c1 != c2) {
                return c1 - c2; // 返回字符差值
            }
        }

        // 如果前面的字符都相同，比较长度
        return len1 - len2;
    }

    @Override
    public String toString() {
        return new String(this.value);
    }

    // 自定义其他方法...
    public boolean equals(SString other) {
        // Check if the lengths are equal
        if (this.value.length != other.length()) {
            return false;
        }

        // Check each character for equality
        for (int i = 0; i < this.value.length; i++) {
            if (this.value[i] != other.charAt(i)) {
                return false;
            }
        }

        // If all characters are equal, the strings are equal
        return true;
    }
}
