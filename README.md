#ssm-template
mybatis默认开启一级缓存（查询）
在一个sqlsession里
一级缓存：一个service方法中多次调用同一个dao中的用一个方法，使用一级缓存
调用两次service方法，不走一级缓存，调用一次会关闭一次
二级缓存：指到的二级缓存（一个namespace，一个二级缓存）