package numeronapp.main;
import java.util.*;
public class Main {
	public static void main(String[] args) {
        int[] ans = makeAnswer();
	    System.out.println("ルール説明");
	    System.out.println("【EAT=数字と位置が合っている】");
	    System.out.println("【BITE=数字のみ合っている(位置は違う)】");
	    System.out.println("① 4桁の数字を当ててください\n② ただし同じ数字は含まれません");
	    System.out.println("ゲームを開始します(「ギブアップ」と入力すると強制終了します)");
		int count = numeronapp.discrimination.Discrimination.challenge(ans);
		if(count == -1){
			System.out.println("ゲームを強制終了しました");
		}else{
	    	System.out.println(count + "回目で正解しました\nゲームを終了します");
		}
	}
	
	public static int[] makeAnswer() { /*4桁のランダムな数字を生成するメソッド*/
		List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            intList.add(i);
        }
        int[] ans = new int[4];
	    for(int i = 0; i < ans.length; i++){
            int random = new java.util.Random().nextInt(intList.size());
	        ans[i] = intList.get(random);
            intList.remove(random);
	    }
	    return ans;
	}
}