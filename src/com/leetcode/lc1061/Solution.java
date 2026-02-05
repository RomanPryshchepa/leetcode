package com.leetcode.lc1061;

import java.util.LinkedList;
import java.util.TreeSet;

/*
1061. Lexicographically Smallest Equivalent String

You are given two strings of the same length s1 and s2 and a string baseStr.

We say s1[i] and s2[i] are equivalent characters.

    For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.

Equivalent characters follow the usual rules of any equivalence relation:

    Reflexivity: 'a' == 'a'.
    Symmetry: 'a' == 'b' implies 'b' == 'a'.
    Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.

For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.



Example 1:

Input: s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is "makkek".

Example 2:

Input: s1 = "hello", s2 = "world", baseStr = "hold"
Output: "hdld"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".

Example 3:

Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
Output: "aauaaaaada"
Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".



Constraints:

    1 <= s1.length, s2.length, baseStr <= 1000
    s1.length == s2.length
    s1, s2, and baseStr consist of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.smallestEquivalentString("parker", "morris", "parser")); // "makkek"
        System.out.println(solution.smallestEquivalentString("hello", "world", "hold")); // "hdld"
        System.out.println(solution.smallestEquivalentString("leetcode", "programs", "sourcecode")); // "aauaaaaada"
        System.out.println(solution.smallestEquivalentString("adbfgjdi", "bccgheej", "abcdefgheij")); // "aaaaafffaaa"

        System.out.println(solution.smallestEquivalentString(
                "tdjwvktzeqpjmcowooiinbwifhlevpanhkuzegzujwcotlvpwjvjvyutahkahmdeotfpfjbxrtdxnurjtxocsuaeubxtlyxocphhgffvzaanlceubvoofqynztfnodqxfxgapzmjzarkmqktarcxcsuxwuyybrhogotbzhvfgmqoccfkvvieawlkhrijqhhervkxtnxprkpaufxmakcbaakyrnolccqznlqzcuspsyxcbtjbangwbuivgoxikpytslyqiyucdwkwlfrvohlgpfjwrmqhxhynnglujehkpifqtfnredhbzyarhcsevimbunsfjjrmvmivhlfomxqdytxcdycgdgveypwzdxopyzumgodltiwvqaxmzpvmollrzkmpkvfiqvteawseykbroalrdnhlhxemakubnircitsfauszcjdtfoylrnthfvqishvwrqosryjsvctaftwncgaqaycpiomfwfnqbjsucnfnkjaayzuwodojfomvxqhcmqstwclngscicjxxodmlywvjkmlctvlottijnhfvrjqiomnzeoeimpzhkiixuudfkrjswavgcdqdtctodjfdiphayeytyhvbsuqsurnprjubwizihmymqneiqihbasaqfhhjamueezjyyvcndsscvijvodtpkfauqptcpqgdoewdekurbuvnrfuhilwtwjvlylsesnzhhtygnlafbwvatpztbexcxthafpdzzrtnndssgknratkuzjwtwnboohukkaritoejjnvgxfcwpnacaxnwmpjjcnjxullbvvmpjzgfjwrjuldrflydeugmbibatxiomspgeaqjohgvgphgiexfdgpqlsbcjrgwesvkstsmmawpgmkislczjxzjcnkglrndrgaocttwnnwnmplanrzwdbgfhomauqifwavqsnwsizfddvfbwokwpvkaytgcipbmoyfwefgsglknvkrrvdswllqcvjaqegonymol",
                "mwpaelgfkztacyrjaugtocuwhskvmhjxdyofyujlrcrrcinamqnrkrtklykykbjzutpvzcpsgpjtaieyzhkysqkkynckgmacuvgqxxiwwtsicmbwysnkigereefkmidfaevtsmwnpgxhbqkqunornfcihizmmyrzzaquwplfiblxaselnlozbvtoucruxpymycjhpsayaantkqocgnnwjkoqecdhacvbprlfvklasrlotokdygxwyigevbwamwuhonwdwtnbszjonnfvyinshbsyxfbegqzurtmhmkwivvcbhweyqtnyxaqcywhmboznwcskkupkieqrreijneeylfybrhzwrxohqjequgumnfizqvzcqonjiwasdcxcmichccjrjnldcedbtrnrrlsknmecwgagvcqgqdxanbxqpcazohlkqsnmxbzcuejxaqvqcnljlilbfavjxntikqcgqmauqnelvvmqtnfzvtzojowrbqbldeslerrenvjxkjpnasncegjxpcpjdbeyckmjbwornyyunpknhfqrtamqxuiaehqxlscebknjwtifmwmcpdqeuohphcduamutsevxxdkrqtcrnvygtqxxigrclspvicdjdrorkxypcdgojbmcvzvkbzochuqrbqfankzdlrwlnwermppwmibhcrkrqbfescffdsfpxxjlpsrldaacqdvtbpctbuvdbqhrfdxprzhfxhlhzpvgvlafsahqojdtngraiqqbhqibnigfyiffzibfxjohwgxseuyefuhnabscazurfdgfamirklkinnqqiiduarzrtfzcnntgclmcxyvawwjhxjkwbodqsjhtcklbaycgsaqmenyzqepqkapeijtpupbfzdlyszmdgwsvztxfvddxxadjiskkxqpxciohrshkgsbykrvgwhqpacjdhzclqsyfwnjvmljulqwudtzexuihorpthpwvzoomygmpbkwsjhmwdebocvwc",
                "eecjkrceairkmucergeekgcndxlcdirlxtwhutsvipnezvzgbovtcstsyyxcvuioijesbzhwzjzgomcsbpnzfpgkwsmohoeklzzrnfzrnsghwcyarhoidscurskqgbmumfneljcujtjqliufvylcrtmdptbwjhzzgcjsfxllcaxnzdqhqibrxtdazjaaeqriztuwwbuagfmidqousefwpekbrvqqosxgvuwltawscqkesbiegulremanrximasheasbkfpdjkdsjazrbkoynomiyhknamduevvevurplqfwzlebqdsrcettmwnafqbgyxbkjircfbuoebudbahwdcvilcgwdrxobgqyibakfjviirlbxyymkpowcsaaewhctxectalcdkgskjhxmrysslkvorrvbbcrpjcbtcgilcvxyjciaxmsczeatammyfxgyxjucpnjqjggivvoqilocwzfscsjjysnmnogkygqrioqqdccgncesmlmyuvfaxkiepnunvacvowlyhhmddiywufqnwfkexpfnyrhafzdjtjzksaqxfwblblmoozcuajbqipcektiqvsffnuxuckpsjubxhxxquywlojrjzcnxxghiuoxpkcxgpjidtnvcndurggfwhqveblvdtikrcbkmetkjirrqjzekxowybqsdqpnahrsugvstwsesohyiukjgccomdaxiwyxirqboohbvlnjnxhkcanayacqbfhnwtjnioacaakcrjfuunnyetnncsmaehlralutauggeghriptxmegazwkkenjuaynyrfcxbliglafbdzyrtkyqovpkrzeecepsdpluiifczwurmgterolqyvdzcrqmlwaqcckcfjtixawftckcorgegaipxckwptvqerchakmmhfkkgjnemnxdvxvgwakohhhhyilkeulsacnhjwevpipawiypezsvtlgdacusxnsyzwcrgmfjeoyxoegaclopmyaay"
        ));
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        var groups = new LinkedList<TreeSet<Character>>();
        boolean inGroups;
        TreeSet<Character> tmpSet;
        for (var i = 0; i < s1.length(); i++) {
            inGroups = false;
            tmpSet = null;
            for (var j = 0; j < groups.size(); j++) {
                if (groups.get(j).contains(s1.charAt(i)) && groups.get(j).contains(s2.charAt(i))) {
                    inGroups = true;
                    break;
                }
                else if (groups.get(j).contains(s1.charAt(i))) {
                    groups.get(j).add(s2.charAt(i));
                    inGroups = true;
                    if (tmpSet == null)
                        tmpSet = groups.get(j);
                    else {
                        groups.get(j).addAll(tmpSet);
                        groups.remove(tmpSet);
                    }
                }
                else if (groups.get(j).contains(s2.charAt(i))) {
                    groups.get(j).add(s1.charAt(i));
                    inGroups = true;
                    if (tmpSet == null)
                        tmpSet = groups.get(j);
                    else {
                        groups.get(j).addAll(tmpSet);
                        groups.remove(tmpSet);
                    }
                }
            }
            if (!inGroups) {
                var set = new TreeSet();
                set.add(s1.charAt(i));
                set.add(s2.charAt(i));
                groups.add(set);
            }
        }
        var sb = new StringBuilder();
        for (var i = 0; i < baseStr.length(); i++) {
            for (var set : groups) {
                if (set.contains(baseStr.charAt(i))) {
                    sb.append(set.first());
                    break;
                }
            }
            if (sb.length() == i)
                sb.append(baseStr.charAt(i));
        }
        return sb.toString();
    }
}
