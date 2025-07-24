import java.util.Arrays;
import java.util.Comparator;

public class nMeetingsInRoom {
    static class Meeting {
        int start;
        int end;
        int index;

        Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static int maxMeetings(int[] start, int[] end) {
        Meeting[] meeting = new Meeting[start.length];
        for (int i = 0; i < start.length; i++) {
            meeting[i] = new Meeting(start[i], end[i], i + 1);
        }

        Arrays.sort(meeting, Comparator.comparingInt(m -> m.end));

        int endTime = meeting[0].end;
        int count = 1;

        for (int i = 1; i < start.length; i++) {
            // meeting[i] = new Meeting(start[i], end[i], i + 1);
            if (meeting[i].start > endTime) {
                count++;
                endTime = meeting[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        int result = maxMeetings(start, end);
        System.out.println("Maximum number of meetings: " + result);
    }

}
