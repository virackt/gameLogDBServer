package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 竞技场日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class GymkhanaLogMessage implements ILogCodec{
	
	public GymkhanaLogMessage(){}
	
	public GymkhanaLogMessage(int serverId,int iUserId,String vAccount,int inBattle,int passBattle,int numOfEnter,int ranking,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.inBattle = inBattle;
					this.passBattle = passBattle;
					this.numOfEnter = numOfEnter;
					this.ranking = ranking;
					this.dActionTime = dActionTime;
			}
	// 事件id
	private long iEventId;
			// 服务器Id
		private int serverId;
			// 用户id
		private int iUserId;
			// 帐号
		private String vAccount;
			// 竞技场进入战斗标志
		private int inBattle;
			// 竞技场战斗结束：1为胜利，2为失败，3为进入战斗
		private int passBattle;
			// 成功进入竞技场后，最新竞技场进入次数
		private int numOfEnter;
			// 竞技场战斗后排名
		private int ranking;
			// 发生时间
		private String dActionTime;
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
			public void setIUserId(int iUserId){
			this.iUserId = iUserId;
		}
		public int getIUserId(){
			return this.iUserId;
		}
			public void setVAccount(String vAccount){
			this.vAccount = vAccount;
		}
		public String getVAccount(){
			return this.vAccount;
		}
			public void setInBattle(int inBattle){
			this.inBattle = inBattle;
		}
		public int getInBattle(){
			return this.inBattle;
		}
			public void setPassBattle(int passBattle){
			this.passBattle = passBattle;
		}
		public int getPassBattle(){
			return this.passBattle;
		}
			public void setNumOfEnter(int numOfEnter){
			this.numOfEnter = numOfEnter;
		}
		public int getNumOfEnter(){
			return this.numOfEnter;
		}
			public void setRanking(int ranking){
			this.ranking = ranking;
		}
		public int getRanking(){
			return this.ranking;
		}
			public void setDActionTime(String dActionTime){
			this.dActionTime = dActionTime;
		}
		public String getDActionTime(){
			return this.dActionTime;
		}
		//@Override
	public void encode(ByteBuffer buffer){
		buffer.putLong(iEventId);
								   buffer.putInt(serverId);
			 								   buffer.putInt(iUserId);
			 								   IoBufferUtil.putString(buffer, vAccount);
			 								   buffer.putInt(inBattle);
			 								   buffer.putInt(passBattle);
			 								   buffer.putInt(numOfEnter);
			 								   buffer.putInt(ranking);
			 								   IoBufferUtil.putString(buffer, dActionTime);
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
				   this.iUserId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.vAccount = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.inBattle = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.passBattle = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.numOfEnter = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.ranking = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10017;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into gymkhanaLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+inBattle+","+passBattle+","+numOfEnter+","+ranking+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table gymkhanaLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器Id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',inBattle int(11) comment'竞技场进入战斗标志',passBattle int(11) comment'竞技场战斗结束：1为胜利，2为失败，3为进入战斗',numOfEnter int(11) comment'成功进入竞技场后，最新竞技场进入次数',ranking int(11) comment'竞技场战斗后排名',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,inBattle,passBattle,numOfEnter,ranking,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(inBattle);
					list.add(passBattle);
					list.add(numOfEnter);
					list.add(ranking);
					list.add(dActionTime);
				return list;
	}
	
}