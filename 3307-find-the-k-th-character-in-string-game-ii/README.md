<h2><a href="https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/">3307. Find the K-th Character in String Game II</a></h2><h3>Hard</h3><hr><div><p>Alice and Bob are playing a game. Initially, Alice has a string <code>word = "a"</code>.</p>

<p>You are given a <strong>positive</strong> integer <code>k</code>. You are also given an integer array <code>operations</code>, where <code>operations[i]</code> represents the <strong>type</strong> of the <code>i<sup>th</sup></code> operation.</p>

<p>Now Bob will ask Alice to perform <strong>all</strong> operations in sequence:</p>

<ul>
	<li>If <code>operations[i] == 0</code>, <strong>append</strong> a copy of <code>word</code> to itself.</li>
	<li>If <code>operations[i] == 1</code>, generate a new string by <strong>changing</strong> each character in <code>word</code> to its <strong>next</strong> character in the English alphabet, and <strong>append</strong> it to the <em>original</em> <code>word</code>. For example, performing the operation on <code>"c"</code> generates <code>"cd"</code> and performing the operation on <code>"zb"</code> generates <code>"zbac"</code>.</li>
</ul>

<p>Return the value of the <code>k<sup>th</sup></code> character in <code>word</code> after performing all the operations.</p>

<p><strong>Note</strong> that the character <code>'z'</code> can be changed to <code>'a'</code> in the second type of operation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">k = 5, operations = [0,0,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">"a"</span></p>

<p><strong>Explanation:</strong></p>

<p>Initially, <code>word == "a"</code>. Alice performs the three operations as follows:</p>

<ul>
	<li>Appends <code>"a"</code> to <code>"a"</code>, <code>word</code> becomes <code>"aa"</code>.</li>
	<li>Appends <code>"aa"</code> to <code>"aa"</code>, <code>word</code> becomes <code>"aaaa"</code>.</li>
	<li>Appends <code>"aaaa"</code> to <code>"aaaa"</code>, <code>word</code> becomes <code>"aaaaaaaa"</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">k = 10, operations = [0,1,0,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">"b"</span></p>

<p><strong>Explanation:</strong></p>

<p>Initially, <code>word == "a"</code>. Alice performs the four operations as follows:</p>

<ul>
	<li>Appends <code>"a"</code> to <code>"a"</code>, <code>word</code> becomes <code>"aa"</code>.</li>
	<li>Appends <code>"bb"</code> to <code>"aa"</code>, <code>word</code> becomes <code>"aabb"</code>.</li>
	<li>Appends <code>"aabb"</code> to <code>"aabb"</code>, <code>word</code> becomes <code>"aabbaabb"</code>.</li>
	<li>Appends <code>"bbccbbcc"</code> to <code>"aabbaabb"</code>, <code>word</code> becomes <code>"aabbaabbbbccbbcc"</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 10<sup>14</sup></code></li>
	<li><code>1 &lt;= operations.length &lt;= 100</code></li>
	<li><code>operations[i]</code> is either 0 or 1.</li>
	<li>The input is generated such that <code>word</code> has <strong>at least</strong> <code>k</code> characters after all operations.</li>
</ul>
</div>