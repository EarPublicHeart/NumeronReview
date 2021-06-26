package numeronapp.discrimination;
import java.util.*;
public class Discrimination{
    public static int challenge(int[] ans){ /*数字が当たるまで正誤判定を繰り返すメソッド*/
	    int count = 0;
		boolean isClear = false;	//ok でフラグを共通化するのではなく、明示的になんのフラグかがわかるようにしておくことが大事
	    while(!isClear){
			/* get console line */
			String strNumbers = new Scanner(System.in).nextLine();
			
			/* input Check Reaction */	// Error を全て関数にできた。リアクションも本来はエラーチェックに含めるべきだが今回は以下のようにしておく。
			int inputCheck = inputErrorCheck(strNumbers);
			if(inputCheck != 0){
				String errMsg = "";
				switch (inputCheck){
					case -1: return -1;	// Give up
					case  1: 
					case  2:
						errMsg = "4桁の数字を入力してください";
						break;
					case  3:
						errMsg = "同じ数字が含まれています";
						break;
					default: break;
				}
				System.out.println(errMsg);
				continue;	
			}

			/* Convert */
			int[] numbers = str2IntArray(strNumbers);

	        int eat = discrimination(ans, numbers);
	        count++;
	        if(eat == 4){
	            isClear = true;
	        }
	    }
		return count;
	}

	/* 
	 * @description:
	 *  Input Error Check Function.
	 * @param:
	 *  input: String
	 * @return:
	 *   0: No Problem
	 *  -1: the player give up 
	 *   1: Length of string is not 4 characters
	 *   2: input includes of not digit value.
	 *   3: input includes 2 same number.
	 */
	private static int inputErrorCheck(String input){
		/* Give up */
		if(input.equals("ギブアップ")){
			return -1;
		}

		/* length must be 4 characters. */
		if(input.length() != 4){
			return 1;
		}

		/* digit check */
		for(int i = 0; i < input.length(); i++){
			if(!(Character.isDigit(input.charAt(i)))){
				return 2;
			}
		}

		/* same number check */ // 
		for(int i = 0; i < input.length(); i++){
			for(int j = i + 1; j < input.length(); j++){
				if(input.charAt(i) == input.charAt(j)) return 3;
			}
		}

		return 0;
	}
	
	/*
	 * @description:
     *  string converts to integer array. length free.
	 * @param:
	 *  str: String
	 * @return:
	 *  numbers: integer array
	 */
	private static int[] str2IntArray(String str){
		int[] numbers = new int[str.length()];
		for(int i = 0; i < str.length(); i++){
			numbers[i] = Character.getNumericValue(str.charAt(i));
		}
		return numbers;
	}

	public static int discrimination(int[] ans, int[] numbers){ /*EATとBITEを数えて表示するメソッド*/
	    int eat = 0;
	    int bite = 0;
	    for(int i = 0; i < 4; i++){
	        for(int j = 0; j < 4; j++){
	            if(numbers[i] == ans[j]){
	                bite++;
	            }
	        }
	    }
	    for(int i = 0; i < 4; i++){
	        if(numbers[i] == ans[i]){
	            eat++;
	        }
	    }
	    System.out.println(eat + "-EAT " + (bite - eat) + "-BITE");
	    return eat;
	}
}