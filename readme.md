# Ŀ��#
 
 ͨ��Demo����ʾjpa-hibernate���ݹ�ϵ�����ݿ⣨MySQL��
 
�������r���ڴ������ݿ�����״̬��EMF��entityManagerFactory,DataSource�� 

User case1���������̡��������� 
 1.�����������ڴ���0���������ݿ����0���������ݿ����
 2.�������̣��ڴ���1���������ݿ����0���������ݿ����
 3.��������1���ڴ���1���������ݿ����1���������ݿ����
 4.��������2���ڴ���1���������ݿ����2���������ݿ����
 5.ɾ������2���ڴ���1���������ݿ����1���������ݿ����
 
User case2���򿪹��̡��򿪳���
 1.�����������ڴ���0���������ݿ����0���������ݿ����
 2.�򿪹��̣��ڴ���1���������ݿ����0���������ݿ����
 3.�򿪳������ڴ���1���������ݿ����1���������ݿ����

	
# �������� #

1.���ݿⶨ��DDL
1.1.�Զ�����DDL
�������ļ�application.properties��������á�spring.jpa.hibernate.ddl-auto����
��������5�����ԣ�create��create-drop��update��validate��none���ر�������£�
��create������ÿ�μ���hibernateʱ������ɾ����һ�����ɱ�Ȼ������û������model�����������±�
                                ע�⣺����2��modelû���κθı�Ҳ������ִ�С�
��create-drop����������hibernate�����к͡�create��һ�������ǵ�SessionFactoryһ�رգ� create�ı���Զ�ɾ����
��update��������õ����ԣ���һ�μ���hibernateʱ����model�������Ժ����hibernateʱ����model���Զ����±�ṹ������ɾ����ǰ�ı��¼��
��validate������ÿ�μ���hibernateʱ����֤���ݱ�ṹ��ֻ������ݿ����Ѿ����ڵı���бȽϣ����ᴴ���±�
��none���������Զ�����DDL��

1.2.����ddlSql
��Ʒ�Ƿ�ʹ��auto-ddl�������Զ�����DDL��
no��Ч������
�Զ����ű�����ddl-auto������ddl��sql������

2.���ݿ����DML
step1.ʹ��JPAע�ⶨ��ģ�ͣ���ģ�Ͷ���ΪEntity��
step2.����ģ�Ͳ����ӿ���xxxRepostiory���ӽӿ�JpaRepository������
step3.��ɾ���˵����
���������ڴ�ģ�ͣ�Ȼ�����xxxRepostiory.save()������
ɾ����������ID������xxxRepostiory.delete()����ɾ���������Ȳ�ѯ��Ҫ�޸ĵĶ��󣬵���xxxRepostiory.delete()����ɾ����
�飬ͨ�����Բ���ʱ����xxxRepostiory�ж���FindByFileds������ͨ������id����ʱ��ֱ�ӵ���xxxRepostiory.indOne()��������ѯ���ж���ʱ����xxxRepostiory.findAll()������
�ģ��Ȳ�ѯ��Ҫ�޸ĵĶ������ڴ�ģ�����޸������ԣ�Ȼ�����xxxRepostiory.save()������

# ������Դ&���ݿ����� #

1.������Դ
����Ҫͬʱ���ݶ�����ݿ�ʱ������Ҫ������Դ��
step1.�������ļ�application.properties�����ö�����ݿ��url��username��password��ͨ����ֵ�����֣����籾���У�project���ݿ������Դ�ļ�ֵ��"spring.datasource.project"��scenario���ݿ������Դ�ļ�ֵ��"spring.datasource.scenario"��
step2.��DataSourceConfig.java��Ϊÿ������ԴDataSource����һ��bean��ʹ��@ConfigurationProperties(prefix="xxx")��step1�ж��������Դ��ֵ�󶨡�
step3.ÿ������Դ����һ��xxxConfig.java�����ڶ��������Դ��EntityManager��TransactionManager��ӳ���ģ�͵�package·����hibernate����ʱ��ɨ�����package�����е�ģ�����������ݿ⡣���ԣ���ͬ���ݿ��µ�ģ��Ҫ���ڲ�ͬ��package�£����籾���У�project���ݿ��ģ�ͷ���package com.huawei.domain.project��scenario���ݿ��ģ�ͷ���package com.huawei.domain.scenario��

�������⣺
1.�����Ǿ�̬���ö�����Դ����һ��Ҫ�о���̬���ö�����Դ��������̬�������ݿ⣬��̬��������Դ��
2.���ݿ�����ȴ����ã�hibernate����ʱ�ŻὨ������Դ���������ӣ���import.sql�����Ӵ������ݿ��sql��Ч����Ϊhibernate������ʱ������ɨ��bean����datasource����ִ��import.sql��

2.�����ݿ�����
�ƺ����ù�ע

# ���� #

# ���� #

# ��ά #

# reference #
