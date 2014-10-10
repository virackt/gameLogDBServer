gameLogDBServer
===============

游戏玩家操作数据日志记录服务器、客户端

mina做通信，用disruptor做消息缓存，然后另起单线程去跑sql存储语句，dbcp做数据库连接池。
