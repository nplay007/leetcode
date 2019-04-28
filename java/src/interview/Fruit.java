package interview;

import java.util.List;

public class Fruit {
    public boolean getFruit(List<List<String>> codeList, List<String> shoppingCart) {
        if (codeList == null || codeList.size() == 0) {
            return true;
        }
        int i = 0, j = 0;
        while (i < codeList.size() && j < shoppingCart.size()) {
            int start = 0;
            while (start < codeList.get(i).size() && (codeList.get(i).get(start).equals("anything") ||
                   codeList.get(i).get(start).equals(shoppingCart.get(j)))) {
                start++;
                j++;
            }
            if (start == codeList.get(i).size()) {
                i++;
            }
            else {
                start = 0;
                j++;
            }
        }
        if (i == codeList.size()) {
            return true;
        }
        return false;
    }
}
