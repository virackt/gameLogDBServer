package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 普通副本日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class NormalBattleLogMessage implements ILogCodec{
	
	public NormalBattleLogMessage(){}
	
	public NormalBattleLogMessage(int serverId,int iUserId,String vAccount,int iUserLv,int gameMapId,int gameLvId,int gameRank,int passBattle,int purpleEquip,int purpleEquipDraw,int numOfEnter,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.iUserLv = iUserLv;
					this.gameMapId = gameMapId;
					this.gameLvId = gameLvId;
					this.gameRank = gameRank;
					this.passBattle = passBattle;
					this.purpleEquip = purpleEquip;
					this.purpleEquipDraw = purpleEquipDraw;
					this.numOfEnter = numOfEnter;
					this.dActionTime = dActionTime;
			}
	// 事件id
	private long iEventId;
			// 服务器id
		private int serverId;
			// 用户id
		private int iUserId;
			// 帐号
		private String vAccount;
			// 战队等级
		private int iUserLv;
			// 每世ID
		private int gameMapId;
			// 关卡ID
		private int gameLvId;
			// 关卡难度
		private int gameRank;
			// 通关该关卡标识：1为通关，0为进入关卡
		private int passBattle;
			// 是否掉落物品1
		private int purpleEquip;
			// 是否掉落物品2
		private int purpleEquipDraw;
			// 成功进入副本后，最新副本剩余进入次数
		private int numOfEnter;
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
			public void setIUserLv(int iUserLv){
			this.iUserLv = iUserLv;
		}
		public int getIUserLv(){
			return this.iUserLv;
		}
			public void setGameMapId(int gameMapId){
			this.gameMapId = gameMapId;
		}
		public int getGameMapId(){
			return this.gameMapId;
		}
			public void setGameLvId(int gameLvId){
			this.gameLvId = gameLvId;
		}
		public int getGameLvId(){
			return this.gameLvId;
		}
			public void setGameRank(int gameRank){
			this.gameRank = gameRank;
		}
		public int getGameRank(){
			return this.gameRank;
		}
			public void setPassBattle(int passBattle){
			this.passBattle = passBattle;
		}
		public int getPassBattle(){
			return this.passBattle;
		}
			public void setPurpleEquip(int purpleEquip){
			this.purpleEquip = purpleEquip;
		}
		public int getPurpleEquip(){
			return this.purpleEquip;
		}
			public void setPurpleEquipDraw(int purpleEquipDraw){
			this.purpleEquipDraw = purpleEquipDraw;
		}
		public int getPurpleEquipDraw(){
			return this.purpleEquipDraw;
		}
			public void setNumOfEnter(int numOfEnter){
			this.numOfEnter = numOfEnter;
		}
		public int getNumOfEnter(){
			return this.numOfEnter;
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
			 								   buffer.putInt(iUserLv);
			 								   buffer.putInt(gameMapId);
			 								   buffer.putInt(gameLvId);
			 								   buffer.putInt(gameRank);
			 								   buffer.putInt(passBattle);
			 								   buffer.putInt(purpleEquip);
			 								   buffer.putInt(purpleEquipDraw);
			 								   buffer.putInt(numOfEnter);
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
				   this.iUserLv = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.gameMapId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.gameLvId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.gameRank = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.passBattle = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.purpleEquip = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.purpleEquipDraw = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.numOfEnter = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10006;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into normalBattleLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+iUserLv+","+gameMapId+","+gameLvId+","+gameRank+","+passBattle+","+purpleEquip+","+purpleEquipDraw+","+numOfEnter+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table normalBattleLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iUserLv int(11) comment'战队等级',gameMapId int(11) comment'每世ID',gameLvId int(11) comment'关卡ID',gameRank int(11) comment'关卡难度',passBattle int(11) comment'通关该关卡标识：1为通关，0为进入关卡',purpleEquip int(11) comment'是否掉落物品1',purpleEquipDraw int(11) comment'是否掉落物品2',numOfEnter int(11) comment'成功进入副本后，最新副本剩余进入次数',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,iUserLv,gameMapId,gameLvId,gameRank,passBattle,purpleEquip,purpleEquipDraw,numOfEnter,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(iUserLv);
					list.add(gameMapId);
					list.add(gameLvId);
					list.add(gameRank);
					list.add(passBattle);
					list.add(purpleEquip);
					list.add(purpleEquipDraw);
					list.add(numOfEnter);
					list.add(dActionTime);
				return list;
	}
	
}