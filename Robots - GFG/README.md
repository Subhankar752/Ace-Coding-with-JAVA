# Robots
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">There are two kinds of bots <strong>A</strong> and <strong>B</strong> in a <strong>1-D</strong> array. <strong>A</strong> bot can only move left while <strong>B</strong> can only move right. There are also empty spaces in between represented by <strong>#</strong>. But its also given that the bots cannot cross over each other. </span></p>

<p><span style="font-size:18px">Given the initial state and final state, we should tell if the transformation is possible.</span></p>

<p><span style="font-size:18px"><strong>NOTE:&nbsp;</strong>There can be many bots of the same type in a particular array.&nbsp;</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
s1 = #B#A#
s2 = ##BA#
<strong>Output:</strong>&nbsp;Yes
<strong>Explanation</strong>: Because&nbsp;we can reach the 
final state by moving 'B' to the 
right one step.</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
s1 = #B#A#
s2 = #A#B# 
<strong>Output:</strong>&nbsp;No
<strong>Explanation</strong>: Because the robots 
cannot cross each other.</span></pre>

<p><br>
<br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>moveRobots()</strong>&nbsp;which takes the initial and final states as strings <strong>s1&nbsp;</strong>and <strong>s2&nbsp;</strong>respectively and returns if&nbsp;a valid transformation can be done. Return "Yes" if possible, else "No".</span><br>
<br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(|s1|)<br>
<strong>Expected Auxiliary Space:</strong> O(|s1|)</span><br>
<br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= <strong>|</strong>s1<strong>|</strong> = <strong>|</strong>s2<strong>|</strong>&nbsp;&lt;= 10<sup>5</sup><br>
The strings only consists of 'A', 'B' and '#'.</span></p>
 <p></p>
            </div>