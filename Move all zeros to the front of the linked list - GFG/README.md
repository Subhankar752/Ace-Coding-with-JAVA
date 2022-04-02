# Move all zeros to the front of the linked list
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a linked list, the task is to move all 0’s to the front of the linked list. The order of all another element except 0 should be same after rearrangement. </span></p>

<p><span style="font-size:18px"><strong>Input:</strong><br>
The first line of input contains an integer <strong>T </strong>denoting the number of test cases. For each test case, the first line contains an integer <strong>N </strong>denoting&nbsp;the number of elements in the Linked List and the second line&nbsp;contains N-space&nbsp;separated integer inputs i.e. elements&nbsp;in the Linked List. </span></p>

<p><span style="font-size:18px"><strong>Output:</strong><br>
For each test case, the output is the modified linked list having all 0's in front.</span></p>

<p><span style="font-size:18px"><strong>User Task:</strong><br>
The task is to complete the function&nbsp;<strong>moveZeroes</strong>() which should move all the 0's to the front of the list.</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= T &lt;= 100<br>
1 &lt;= N &lt;= 50<br>
<strong>Note:&nbsp;</strong>List is from back to front.</span></p>

<p><span style="font-size:18px"><strong>Example:<br>
Input:</strong><br>
2<br>
10<br>
0 1 0 1 2 0 5 0 4 0<br>
7<br>
0 0 0 3 2 1 1</span></p>

<p><span style="font-size:18px"><strong>Output:</strong><br>
0 0 0 0 0&nbsp;4 5 2 1 1<br>
0 0 0 1 1 2 3</span></p>

<p><span style="font-size:18px"><strong>Explanation:<br>
1.&nbsp;</strong>Original list was 0-&gt;4-&gt;0-&gt;5-&gt;0-&gt;2-&gt;1-&gt;0-&gt;1-&gt;0-&gt;NULL.<br>
&nbsp; &nbsp; &nbsp;After processing list becomes 0-&gt;0-&gt;0-&gt;0-&gt;0-&gt;4-&gt;5-&gt;2-&gt;1-&gt;1-&gt;NULL.<br>
<strong>2.</strong>&nbsp;Original list was 1-&gt;1-&gt;2-&gt;3-&gt;0-&gt;0-&gt;0-&gt;NULL.<br>
&nbsp; &nbsp; After processing&nbsp;list becomes 0-&gt;0-&gt;0-&gt;1-&gt;1-&gt;2-&gt;3-&gt;NULL.</span><br>
&nbsp;</p>
 <p></p>
            </div>