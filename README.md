# fanwSocialApp

## 为毕设项目编写的后端程序
- 使用Spring boot和Mybatis框架实现

## 已经实现的功能
- 用户的登陆，注册，登出，登陆状态修改
- 用户信息的创建，更新，获取
- 用户fans，ups的获取，新的follow，取消follow
- 个人部分接口返回信息全部修改为Json格式
- essay的发表，查询，点赞
- comment的发表，删除，查询

## 需要补充
- essay的分页效果，帮助前端实现底部记载的效果（已解决）
- essay/create方法下的pic_1,pic_2,pic_3全部需要提供，没有办法提供null，尝试再添加两条mapping或者找到允许不传值的方法
- 使用user_id获得profile的时候同时返回user_name等必要的信息，节约一次请求的时间（已解决）

## 存在的问题
- 显示一个用户收到的全部comment的时候，无法再sql语句中直接获得相应评论人的name，head
