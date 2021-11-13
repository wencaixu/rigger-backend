压缩算法的比较

4KB的压缩情况

Gzip	4117.0B	1788.0B	0.56	102ms	69ms	1075ms	1203ms	
DeflaterZip	4120.0B	1880.0B	0.54	92ms	62ms	1066ms	1048ms	
Snappy	4117.0B	2326.0B	0.43	51ms	72ms	1169ms	1094ms	


10KB的压缩情况 
            压缩前       压缩后    压缩率   压缩1000次时间    解压100次    redis取1000次未解压      从redis中取1000次并解压
Gzip	    10586.0B	7396.0B	 0.30	  329ms	        203ms	    1616ms	                1811ms
DeflaterZip	10586.0B	7868.0B	 0.25	  296ms	        182ms	    1186ms	                1282ms
Snappy	    10588.0B	9692.0B	 0.08	  181ms	        154ms	    1198ms	                1363ms


20KB的压缩情况
    
Gzip	    21172.0B	7610.0B	    0.64	436ms	240ms	2052ms	1665ms
DeflaterZip	21172.0B	8382.0B	    0.60	311ms	223ms	1695ms	1505ms
Snappy	    21172.0B	10450.0B	0.50	213ms	172ms	1903ms	1682ms


30KB的压缩情况

Gzip	    31758.0B	7836.0B	    0.75	466ms	268ms	2261ms	2416ms
DeflaterZip	31758.0B	8764.0B	    0.72	328ms	275ms	2305ms	2516ms
Snappy	    31764.0B	11342.0B	0.64	235ms	220ms	2040ms	1971ms
redis取数据性能分析

4KB	1075ms
10KB	1186ms
20KB	1903ms
30KB	2261ms
结论:
Gzip和DeflaterZip压缩率比较高,但是压缩时间较长,snappy压缩率较低,压缩时间较短

压缩率和压缩时间都会随value大小变化,使用压缩算法前最好先对目标value大小评估一下再做决定

从解决redis瓶颈方面考虑,如果应用是单节点部署, 将字符串压缩后存储redis是可以节省redis空间的, 但是在取数据时加上解压缩的时间总耗时并没有明显的优化,

如果应用是多节点部署,可以分摊解压缩的时间,可以对redis瓶颈有帮助