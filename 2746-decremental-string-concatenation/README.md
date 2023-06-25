<h2><a href="https://leetcode.com/problems/decremental-string-concatenation/">2746. Decremental String Concatenation</a></h2><h3>Medium</h3><hr><div><p>You are given a <strong>0-indexed</strong> array <code>words</code> containing <code>n</code> strings.</p>

<p>Let's define a <strong>join</strong> operation <code>join(x, y)</code> between two strings <code>x</code> and <code>y</code> as concatenating them into <code>xy</code>. However, if the last character of <code>x</code> is equal to the first character of <code>y</code>, one of them is <strong>deleted</strong>.</p>

<p>For example <code>join("ab", "ba") = "aba"</code> and <code>join("ab", "cde") = "abcde"</code>.</p>

<p>You are to perform <code>n - 1</code> <strong>join</strong> operations. Let <code>str<sub>0</sub> = words[0]</code>. Starting from <code>i = 1</code> up to <code>i = n - 1</code>, for the <code>i<sup>th</sup></code> operation, you can do one of the following:</p>

<ul>
	<li>Make <code>str<sub>i</sub> = join(str<sub>i - 1</sub>, words[i])</code></li>
	<li>Make <code>str<sub>i</sub> = join(words[i], str<sub>i - 1</sub>)</code></li>
</ul>

<p>Your task is to <strong>minimize</strong> the length of <code>str<sub>n - 1</sub></code>.</p>

<p>Return <em>an integer denoting the minimum possible length of</em> <code>str<sub>n - 1</sub></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["aa","ab","bc"]
<strong>Output:</strong> 4
<strong>Explanation: </strong>In this example, we can perform join operations in the following order to minimize the length of str<sub>2</sub>: 
str<sub>0</sub> = "aa"
str<sub>1</sub> = join(str<sub>0</sub>, "ab") = "aab"
str<sub>2</sub> = join(str<sub>1</sub>, "bc") = "aabc" 
It can be shown that the minimum possible length of str<sub>2</sub> is 4.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["ab","b"]
<strong>Output:</strong> 2
<strong>Explanation:</strong> In this example, str<sub>0</sub> = "ab", there are two ways to get str<sub>1</sub>: 
join(str<sub>0</sub>, "b") = "ab" or join("b", str<sub>0</sub>) = "bab". 
The first string, "ab", has the minimum length. Hence, the answer is 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> words = ["aaa","c","aba"]
<strong>Output:</strong> 6
<strong>Explanation:</strong> In this example, we can perform join operations in the following order to minimize the length of str<sub>2</sub>: 
str<sub>0</sub> = "aaa"
str<sub>1</sub> = join(str<sub>0</sub>, "c") = "aaac"
str<sub>2</sub> = join("aba", str<sub>1</sub>) = "abaaac"
It can be shown that the minimum possible length of str<sub>2</sub> is 6.
</pre>

<div class="notranslate" style="all: initial;">&nbsp;</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 50</code></li>
	<li>Each character in <code>words[i]</code> is an English lowercase letter</li>
</ul>
</div>