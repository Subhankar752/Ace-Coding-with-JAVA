<h2><a href="https://leetcode.com/problems/sorting-three-groups/">2826. Sorting Three Groups</a></h2><h3>Medium</h3><hr><div><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of length <code>n</code>.<br>
<br>
The numbers from <code>0</code> to <code>n - 1</code> are divided into three groups numbered from <code>1</code> to <code>3</code>, where number <code>i</code> belongs to group <code>nums[i]</code>. Notice that some groups may be <strong>empty</strong>.<br>
<br>
You are allowed to perform this operation any number of times:</p>

<ul>
	<li>Pick number <code>x</code> and change its group. More formally, change <code>nums[x]</code> to any number from <code>1</code> to <code>3</code>.</li>
</ul>

<p>A new array <code>res</code> is constructed using the following procedure:</p>

<ol>
	<li>Sort the numbers in each group independently.</li>
	<li>Append the elements of groups <code>1</code>, <code>2</code>, and <code>3</code> to <code>res</code> <strong>in this order</strong>.</li>
</ol>

<p>Array <code>nums</code> is called a <strong>beautiful array</strong> if the constructed array <code>res</code> is sorted in <strong>non-decreasing</strong> order.</p>

<p>Return <em>the <strong>minimum</strong> number of operations to make </em><code>nums</code><em> a <strong>beautiful array</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,1,3,2,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> It's optimal to perform three operations:
1. change nums[0] to 1.
2. change nums[2] to 1.
3. change nums[3] to 1.
After performing the operations and sorting the numbers in each group, group 1 becomes equal to [0,1,2,3,4] and group 2 and group 3 become empty. Hence, res is equal to [0,1,2,3,4] which is sorted in non-decreasing order.
It can be proven that there is no valid sequence of less than three operations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,2,1,3,3]
<strong>Output:</strong> 2
<strong>Explanation:</strong> It's optimal to perform two operations:
1. change nums[1] to 1.
2. change nums[2] to 1.
After performing the operations and sorting the numbers in each group, group 1 becomes equal to [0,1,2,3], group 2 becomes empty, and group 3 becomes equal to [4,5]. Hence, res is equal to [0,1,2,3,4,5] which is sorted in non-decreasing order.
It can be proven that there is no valid sequence of less than two operations.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [2,2,2,2,3,3]
<strong>Output:</strong> 0
<strong>Explanation:</strong> It's optimal to not perform operations.
After sorting the numbers in each group, group 1 becomes empty, group 2 becomes equal to [0,1,2,3] and group 3 becomes equal to [4,5]. Hence, res is equal to [0,1,2,3,4,5] which is sorted in non-decreasing order.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 3</code></li>
</ul>
</div>