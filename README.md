# Java-Online-Chat
基于 Java 的在线聊天系统。实现了登录和注册功能及界面，实现了聊天功能，但未实现聊天界面，使用控制台聊天。本程序基于 TCP 协议，多线程技术。仅供学习和参考。

## 功能

### 客户端

* 使用 MySQL 保存用户信息，实现注册和登录。
* 使用多线程技术，聊天和接收消息同步进行。
* 添加好友，对方将收到要求添加好友的信息。
* 发送消息，输入用户名即可给对方发送消息。

注：当前版本数据库没有存储每个用户的好友信息，即可以给任何已经注册的用户发送消息，

### 服务器端

* 使用多线程技术同时给多个用户提供服务。
* 消息缓存：即使对方不在线，消息将暂存服务器端，待对方上线后，再把消息发送给对方。



## 目录结构

客户端

```
├── UI																		注册与登录界面（使用 swing）
│   ├── Main.java
│   ├── MainChatWin.java
│   ├── Register.java
│   └── ShowDialog.java
├── json-simple-1.1.1.jar									序列化包 
├── mysql-connector-java-8.0.22.jar				数据库驱动
├── serverTools														
│   ├── ClientThread.java
│   ├── Information.java
│   ├── SendMsg.java
│   └── TcpClient.java										入口
├── sql
│   └── Sql.java
└── tools																	
    ├── ExistJudge.java										判断用户是否存在
    └── MyJson.java												序列化工具
```



服务器端

```
├── json-simple-1.1.1.jar									序列化包
├── serve								
│   ├── Information.java
│   ├── MsgMange.java
│   ├── MsgStore.java
│   ├── OnlineUser.java
│   ├── ServerThread.java
│   └── TcpServer.java										入口
└── tools
    ├── JudgeOnline.java									判断用户是否在线
    └── MyJson.java												序列化工具

```



## 程序界面

### 登录与注册

注：本版本未实现端到端加密

<img src="http://qqimage.wangjunblogs.com/uPic/image-20211012164508433.png" alt="image-20211012164508433" style="zoom: 50%;" />



### 注册

<img src="http://qqimage.wangjunblogs.com/uPic/image-20211012164602716.png" alt="image-20211012164602716" style="zoom: 50%;" />



### 聊天

使用账号登录之后，先设置一个用户名，可以看作昵称。

如下图所示，当前登录用户为小明。给小红发送消息，当小红登录后可以收到该消息。

<img src="http://qqimage.wangjunblogs.com/uPic/image-20211012165230962.png" alt="image-20211012165230962" style="zoom:50%;" />



左下，小红登录后，收到消息“你好”。右边，服务器运行信息。

<img src="http://qqimage.wangjunblogs.com/uPic/%E6%88%AA%E5%B1%8F2021-10-12%20%E4%B8%8B%E5%8D%884.55.22.png" alt="截屏2021-10-12 下午4.55.22" style="zoom: 50%;" />



