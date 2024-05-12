<h2><a href="https://leetcode.com/problems/minimum-substring-partition-of-equal-character-frequency/">3144. Minimum Substring Partition of Equal Character Frequency</a></h2><h3>Medium</h3><hr><div><p>Given a string <code>s</code>, you need to partition it into one or more <strong>balanced</strong> <span data-keyword="substring">substrings</span>. For example, if <code>s == "ababcc"</code> then <code>("abab", "c", "c")</code>, <code>("ab", "abc", "c")</code>, and <code>("ababcc")</code> are all valid partitions, but <code>("a", <strong>"bab"</strong>, "cc")</code>, <code>(<strong>"aba"</strong>, "bc", "c")</code>, and <code>("ab", <strong>"abcc"</strong>)</code> are not. The unbalanced substrings are bolded.</p>

<p>Return the <strong>minimum</strong> number of substrings that you can partition <code>s</code> into.</p>

<p><strong>Note:</strong> A <strong>balanced</strong> string is a string where each character in the string occurs the same number of times.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "fabccddg"</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>We can partition the string <code>s</code> into 3 substrings in one of the following ways: <code>("fab, "ccdd", "g")</code>, or <code>("fabc", "cd", "dg")</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abababaccddb"</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>We can partition the string <code>s</code> into 2 substrings like so: <code>("abab", "abaccddb")</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists only of English lowercase letters.</li>
</ul>
</div>