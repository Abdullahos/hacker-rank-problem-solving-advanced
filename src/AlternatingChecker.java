
public class AlternatingChecker {

}
static int alternatingCharacters(String s) {
    int counts = 0;
    int length = s.length();
    while(s.indexOf("AA") != -1 || s.indexOf("BB") != -1){
        int idxAA = s.indexOf("AA");
        if(idxAA != -1) {
            s = s.substring(0,idxAA+1)+s.substring(idxAA+2);
            counts++;
        }
        int idxBB = s.indexOf("BB");
        if(idxBB != -1) {
            s = s.substring(0,idxBB+1)+s.substring(idxBB+2);
            counts++;
        }
    }
 return counts;
}