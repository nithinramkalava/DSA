import java.util.ArrayList;
import java.util.List;

public class ClimbingTheLeaderBoard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> ranks = new ArrayList<>();
        List<Integer> playerRanks = new ArrayList<>();

        ranks.add(1);
        for (int i = 1; i < ranked.size(); i++){
            if (ranked.get(i) == ranked.get(i-1))
                ranks.add(ranks.get(i-1));
            else ranks.add(ranks.get(i-1) + 1);
        }

        for (int i = 0; i < player.size(); i++){
            int score = player.get(i);
            if (score > ranks.get(0))
                playerRanks.add(1);
            else if (score < player.get(player.size() - 1)) 
                playerRanks.add(ranks.get(ranks.size() - 1));
            else {
                int index = binarySearch(ranks, score);
                playerRanks.add(ranks.get(index));
            }
        }


        return playerRanks;
    }
    private static int binarySearch(List<Integer> arr, int element) {
		int low = 0, high = arr.size() - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr.get(mid) == element) {
				return mid + 1;
			}
            else if (element < arr.get(mid) && element >= arr.get(mid+1)){
                return mid + 1;
            }
            else if (element > arr.get(mid) && element <= arr.get(mid-1)){
                return mid;
            }
            else if (element < arr.get(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
    public static void main(String[] args) {
        
    }
}
