## 简单排序  

1.选择排序  

* 时间复杂度 N(N-1)/2  
* 向后遍历，与最小元素交换位置

2.插入排序

* 时间复杂度 N<sup>2</sup>/4 比选择排序快2倍
* 最快N-1 比选择排序快
* 倒序时 N<sup>2</sup>/2次比较+N<sup>2</sup>/2次交换 比选择排序慢
* 未排序数组选一个值，拿来往前遍历比较，如果比前一个元素小则交换位置