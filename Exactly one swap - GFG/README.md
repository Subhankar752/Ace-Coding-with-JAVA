# Exactly one swap
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a string <strong>S</strong> containing&nbsp;lowercase english alphabet&nbsp;characters. The task is to calculate the number of distinct strings that can be obtained after performing&nbsp;exactly one swap.<br>
In one swap,Geek can&nbsp;pick two distinct index <strong>i</strong> and <strong><u>j</u></strong> (i.e 1 <u>&lt;</u> i &lt; j <u>&lt;</u> |S|&nbsp;)&nbsp;of the string, then swap the characters at the position i and j.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
S = "geek"
<strong>Output:</strong> 
6
<strong>Explanation: 
</strong>After one swap, There are only 6 distinct strings 
possible.(i.e "egek","eegk","geek","geke","gkee" and 
"keeg")
</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>S = "ab"
<strong>Output: 
</strong>1
<strong>Explanation:</strong>
Only one string is possible after one swap(i.e "ba")</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;</strong><br>
You don't need to read input or print anything. Complete the function<strong>&nbsp;countStrings( )</strong>&nbsp;which takes the string <strong>S</strong>&nbsp;as input parameters and returns the required answer.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(|S|) .<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(1) .</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
2&nbsp;≤&nbsp;|S|&nbsp;≤&nbsp;10<sup>5</sup><br>
S contains lowercase characters</span></p>
 <p></p>
            </div>