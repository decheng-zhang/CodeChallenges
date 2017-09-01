import java.lang.StringBuilder;
class Solution {
    public boolean isStrobogrammatic(String num) {
        
        //rotating by 180 degree -> string is reversed
        //6->9, 9->6, 8->8, 1->1, 0->0
        String SR = new StringBuilder(num).reverse().toString();
        char[] CR = SR.toCharArray();
        for (int i=0;i<CR.length;i++)
        {
            if (!(CR[i]=='6' || CR[i]=='9' || CR[i]=='8' || CR[i]=='1' || CR[i]=='0'))
                return false;
            if (CR[i]=='6')
                CR[i]='9';
            else if (CR[i]=='9')
                CR[i]='6';
        }
        SR = new String(CR);
        if (SR.equals(num))
            return true;
        else
            return false;
    }
}
