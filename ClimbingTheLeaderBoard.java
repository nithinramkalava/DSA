import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClimbingTheLeaderBoard {

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    
    List<Integer> inputs = new ArrayList<Integer>();
    ranked = ranked.stream().distinct().collect(Collectors.toList());

    int j = 0;
    int i = ranked.size() - 1;
    while (i >= 0 && j < player.size()) {
      boolean iValid = (i > 0);
      if (ranked.get(i) > player.get(j)) {
        inputs.add(i + 2);
        j++;
      } else {
        if (ranked.get(i).equals(player.get(j)) || (i == 0 && ranked.get(i) < player.get(j))) {
            inputs.add(i + 1);
            j++;
            i = iValid ? i - 1 : 0;
        } else {
          i = iValid ? i - 1 : 0;
        }
      }
    }
    return inputs;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Integer> ranker = new ArrayList<>();

    for (int i = 0; i < n; i++) ranker.add(sc.nextInt());

    int m = sc.nextInt();
    List<Integer> player = new ArrayList<>();

    for (int i = 0; i < m; i++) player.add(sc.nextInt());

    sc.close();

    System.out.println(climbingLeaderboard(ranker, player).toString());
  }
}
