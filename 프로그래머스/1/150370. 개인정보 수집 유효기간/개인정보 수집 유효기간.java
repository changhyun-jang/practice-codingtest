import java.util.ArrayList;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜 나누기.
        String[] splitToday = today.split("[.]");
        int todayY = Integer.parseInt(splitToday[0]);
        int todayM = Integer.parseInt(splitToday[1]);
        int todayD = Integer.parseInt(splitToday[2]);

        // terms 나누기
        String[][] splitTerm = new String[terms.length][2];
        for (int i = 0; i < terms.length; i++) {
            splitTerm[i] = terms[i].split(" ");
        }

        // privacies 나누기
        String[][] splitPrivacies = new String[privacies.length][2];
        for (int i = 0; i < privacies.length; i++) {
            splitPrivacies[i] = privacies[i].split(" ");
        }

        // privacies의 문자를 숫자로 바꾸기.
        for (int i = 0; i < privacies.length; i++) {
            for (int j = 0; j < terms.length; j++) {
                if (splitTerm[j][0].equals(splitPrivacies[i][1])) {
                    splitPrivacies[i][1] = splitTerm[j][1];
                    break;
                }
            }
        }

        // 각 privacies의 마감기한 날짜 계산하기.
        // 파기해야할 인덱스들을 담을 List선언
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            // privacies안에 들어있는 날짜 나누기
            // 0->년, 1->월, 2->일
            String[] dateSplit = splitPrivacies[i][0].split("[.]");
            int tempY = Integer.parseInt(dateSplit[0]);
            int tempM = Integer.parseInt(dateSplit[1]);
            int tempD = Integer.parseInt(dateSplit[2]);

            // 파기기한
            int expireDate = Integer.parseInt(splitPrivacies[i][1]);

            // 월 + 파기기한
            int tempCal = tempM + expireDate;

            // 해가 바뀌는 걸 의미
            // 12로 나눴을떄 1보다 크고, 나머지가 0이 아닐 때
            if (tempCal > 12) {
                // 12로나눠서 나머지가 없다면 12의 배수가 아니므로
                if (tempCal % 12 != 0) {
                    tempY += tempCal / 12;
                    tempM = tempCal - 12 * (tempCal / 12);
                } else {
                    tempY += ((tempCal / 12) - 1);
                    tempM = 12;
                }
            } else {
                // 해가 안바뀌는 경우,
                if (tempCal % 12 != 0) {
                    tempM = tempCal % 12;
                } else {
                    tempM = 12;
                }
            }

            if (tempD != 1) {
                tempD -= 1;
            } else {
                if (tempM != 1) {
                    tempM -= 1;
                } else {
                    tempY -= 1;
                    tempM = 12;
                }
                tempD = 28;
            }

            if (todayY > tempY) {
                arr.add(i + 1);
            } else if (todayY == tempY) {
                if (todayM > tempM) {
                    arr.add(i + 1);
                } else if (todayM == tempM) {
                    if (todayD > tempD) {
                        arr.add(i+1);
                    }
                }
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}