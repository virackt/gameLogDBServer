package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 实时在线
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class OnlineLogMessage implements ILogCodec{
	
	public OnlineLogMessage(){}
	
	public OnlineLogMessage(int serverId,String dActionTime,int onlineNum){
					this.serverId = serverId;
					this.dActionTime = dActionTime;
					this.onlineNum = onlineNum;
			}
	// 事件id
	private long iEventId;
			// 服务器id
		private int serverId;
			// 每小时记录一次
		private String dActionTime;
			// 每时段在线人数
		private int onlineNum;
		public void setIEventId(long iEventId){
		this.iEventId = iEventId;
	}
	public long getIEventId(){
		return this.iEventId;
	}
			public void setServerId(int serverId){
			this.serverId = serverId;
		}
		public int getServerId(){
			return this.serverId;
		}
			public void setDActionTime(String dActionTime){
			this.dActionTime = dActionTime;
		}
		public String getDActionTime(){
			return this.dActionTime;
		}
			public void setOnlineNum(int onlineNum){
			this.onlineNum = onlineNum;
		}
		public int getOnlineNum(){
			return this.onlineNum;
		}
		//@Override
	public void encode(ByteBuffer buffer){
		buffer.putLong(iEventId);
								   buffer.putInt(serverId);
			 								   IoBufferUtil.putString(buffer, dActionTime);
			 								   buffer.putInt(onlineNum);
			 			}
	//@Override
	public void decode(ByteBuffer buffer){
		if(buffer.hasRemaining()){
			this.iEventId = buffer.getLong();
		}
									if(buffer.hasRemaining()){
				   this.serverId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.onlineNum = buffer.getInt();
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10010;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into onlineLog values(" + iEventId + "," + serverId+","+"'" + dActionTime+ "'"+","+onlineNum + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table onlineLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器id',dActionTime timestamp comment'每小时记录一次',onlineNum int(11) comment'每时段在线人数',primary key(serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,dActionTime,onlineNum);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(dActionTime);
					list.add(onlineNum);
				return list;
	}
	
}