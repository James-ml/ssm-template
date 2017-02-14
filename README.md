#ssm-template

《1》该项目主要使用ssm框架（spring、springmvc、mybatis）对表进行增删改查<br>
《2》查询使用到了redis缓存<br>
《3》对表进行修改和插入数据的时候，对数据进行了校验，使用到了hibernate-validator<br>
《4》对表单提交进行了前台json-->后台返回json、前台key/value-->后台返回json进行了测试 <br>
《5》访问后台的时候，使用拦截器对url进行了拦截，即登录才可以访问<br>
其他：<br>
mybatis默认开启一级缓存（查询）<br>
在一个sqlsession里<br>
一级缓存：一个service方法中多次调用同一个dao中的同一个方法，使用一级缓存<br>
调用两次service方法，不走一级缓存，调用一次会关闭一次<br>
二级缓存：指到的二级缓存（一个namespace，一个二级缓存）<br>
