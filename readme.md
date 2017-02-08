# 目的#
 
 通过Demo，演示jpa-hibernate操纵关系型数据库（MySQL）
 
描述各時序，内存中数据库对象的状态（EMF，entityManagerFactory,DataSource） 

User case1：创建工程、创建场景 
 1.服务启动，内存中0个工程数据库对象，0个场景数据库对象
 2.创建工程，内存中1个工程数据库对象，0个场景数据库对象
 3.创建场景1，内存中1个工程数据库对象，1个场景数据库对象
 4.创建场景2，内存中1个工程数据库对象，2个场景数据库对象
 5.删除场景2，内存中1个工程数据库对象，1个场景数据库对象
 
User case2：打开工程、打开场景
 1.服务启动，内存中0个工程数据库对象，0个场景数据库对象
 2.打开工程，内存中1个工程数据库对象，0个场景数据库对象
 3.打开场景，内存中1个工程数据库对象，1个场景数据库对象

	
# 基本操作 #

1.数据库定义DDL
1.1.自动生成DDL
在配置文件application.properties中添加配置“spring.jpa.hibernate.ddl-auto”。
该配置有5个属性：create、create-drop、update、validate、none，特别解释如下：
【create】——每次加载hibernate时，都会删除上一次生成表，然后根据用户定义的model类重新生成新表。
                                注意：哪怕2次model没有任何改变也会这样执行。
【create-drop】——加载hibernate过程中和【create】一样，但是当SessionFactory一关闭， create的表就自动删除。
【update】——最常用的属性，第一次加载hibernate时根据model创建表，以后加载hibernate时根据model类自动更新表结构，不会删除以前的表记录。
【validate】——每次加载hibernate时，验证数据表结构，只会和数据库中已经存在的表进行比较，不会创建新表。
【none】——不自动生成DDL。

1.2.导入ddlSql
产品是否使用auto-ddl配置来自动生成DDL？
no，效率问题
自动化脚本调用ddl-auto，生成ddl—sql并导入

2.数据库操纵DML
step1.使用JPA注解定义模型，将模型定义为Entity。
step2.定义模型操作接口类xxxRepostiory，从接口JpaRepository派生。
step3.增删查改说明：
增，构造内存模型，然后调用xxxRepostiory.save()方法；
删，输入主键ID，调用xxxRepostiory.delete()方法删除，或者先查询到要修改的对象，调用xxxRepostiory.delete()方法删除；
查，通过属性查找时，在xxxRepostiory中定义FindByFileds方法，通过主键id查找时，直接调用xxxRepostiory.indOne()方法，查询所有对象时调用xxxRepostiory.findAll()方法；
改，先查询到要修改的对象，在内存模型中修改其属性，然后调用xxxRepostiory.save()方法。

# 多数据源&数据库连接 #

1.多数据源
当需要同时操纵多个数据库时，就需要多数据源。
step1.在配置文件application.properties中配置多个数据库的url、username、password，通过键值来区分，例如本例中，project数据库的数据源的键值是"spring.datasource.project"，scenario数据库的数据源的键值是"spring.datasource.scenario"。
step2.在DataSourceConfig.java中为每个数据源DataSource定义一个bean，使用@ConfigurationProperties(prefix="xxx")与step1中定义的数据源键值绑定。
step3.每个数据源定义一个xxxConfig.java，用于定义该数据源的EntityManager、TransactionManager和映射的模型的package路径，hibernate启动时会扫描这个package下所有的模型来定义数据库。所以，不同数据库下的模型要放在不同的package下，例如本例中，project数据库的模型放在package com.huawei.domain.project，scenario数据库的模型放在package com.huawei.domain.scenario。

遗留问题：
1.以上是静态配置多数据源，下一步要研究动态配置多数据源，包括动态创建数据库，动态配置数据源。
2.数据库必须先创建好，hibernate启动时才会建立数据源和数据连接，在import.sql中增加创建数据库的sql无效，因为hibernate启动的时候，是先扫描bean生成datasource，后执行import.sql。

2.多数据库连接
似乎不用关注

# 事务 #

# 性能 #

# 运维 #

# reference #
