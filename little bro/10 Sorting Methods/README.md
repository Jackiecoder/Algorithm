# Time Complexity of 10 different sorting 
### 以升序为例
1. bubble sort: O($n^{2}$)
$每次对比两个元素，如果大小顺序相反就交换。如果在升序中，如果左比右大，则交换。$
2. selection sort: O($n^{2}$)
$在未排序的数组中找出最大值放到排序队列尾。$
3. insert sort: O($n^{2}$)
$在未排序的数组中，取第一个值，在排序数组中找到它的位置。$
4. quick sort: O($nlog_{n}$)
$取list头做标记，小于标记的放在左边，大于标记的放在右边。$
5. merge sort: O($nlog_{n}$)
$把list 无限对半分，再将每一小块排序。$
6. shell sort: best: O($nlog_{n}$), worst: O($nlog^{2}_{n}$)


