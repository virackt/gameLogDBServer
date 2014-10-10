package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 锁屏后启动游戏日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class ResumeLogMessage implements ILogCodec{
	
	public ResumeLogMessage(){}
	
	public ResumeLogMessage(int serverId,String vUuid,String vQudaoTag,String vMachineBrand,String vMachineSystem,String dActionTime){
					this.serverId = serverId;
					this.vUuid = vUuid;
					this.vQudaoTag = vQudaoTag;
					this.vMachineBrand = vMachineBrand;
					this.vMachineSystem = vMachineSystem;
					this.dActionTime = dActionTime;
			}
	// 事件id
	private long iEventId;
			// 服务器Id
		private int serverId;
			// 设备唯一id
		private String vUuid;
			// 渠道标记
		private String vQudaoTag;
			// 设备品牌
		private String vMachineBrand;
			// 设备系统版本号
		private String vMachineSystem;
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
			public void setVUuid(String vUuid){
			this.vUuid = vUuid;
		}
		public String getVUuid(){
			return this.vUuid;
		}
			public void setVQudaoTag(String vQudaoTag){
			this.vQudaoTag = vQudaoTag;
		}
		public String getVQudaoTag(){
			return this.vQudaoTag;
		}
			public void setVMachineBrand(String vMachineBrand){
			this.vMachineBrand = vMachineBrand;
		}
		public String getVMachineBrand(){
			return this.vMachineBrand;
		}
			public void setVMachineSystem(String vMachineSystem){
			this.vMachineSystem = vMachineSystem;
		}
		public String getVMachineSystem(){
			return this.vMachineSystem;
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
			 								   IoBufferUtil.putString(buffer, vUuid);
			 								   IoBufferUtil.putString(buffer, vQudaoTag);
			 								   IoBufferUtil.putString(buffer, vMachineBrand);
			 								   IoBufferUtil.putString(buffer, vMachineSystem);
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
				   this.vUuid = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.vQudaoTag = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.vMachineBrand = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.vMachineSystem = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10012;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into resumeLog values(" + iEventId + "," + serverId+","+"'" + vUuid+ "'"+","+"'" + vQudaoTag+ "'"+","+"'" + vMachineBrand+ "'"+","+"'" + vMachineSystem+ "'"+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table resumeLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器Id',vUuid varchar(100) comment'设备唯一id',vQudaoTag varchar(100) comment'渠道标记',vMachineBrand varchar(100) comment'设备品牌',vMachineSystem varchar(100) comment'设备系统版本号',dActionTime timestamp comment'发生时间',primary key(serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,vUuid,vQudaoTag,vMachineBrand,vMachineSystem,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(vUuid);
					list.add(vQudaoTag);
					list.add(vMachineBrand);
					list.add(vMachineSystem);
					list.add(dActionTime);
				return list;
	}
	
}