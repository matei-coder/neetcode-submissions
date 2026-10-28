class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            sb.append((char) ((columnNumber - 1) % 26 + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }

        return sb.reverse().toString();
    }
}