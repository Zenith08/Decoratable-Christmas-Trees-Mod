package me.kk47.dct.network;

import io.netty.buffer.ByteBuf;
import me.kk47.dct.te.TileEntityChristmasTreeTrains;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class TPacketTrainChangeSpeed implements IMessage{
	private byte newSpeed;
	private BlockPos pos;

	public TPacketTrainChangeSpeed() {
		newSpeed = 0;
		pos = new BlockPos(0, 0, 0);
	}

	public TPacketTrainChangeSpeed(byte newSpeed, BlockPos pos) {
		this.newSpeed = newSpeed;
		this.pos = pos;
	}

	public byte getNewSpeed() {
		return newSpeed;
	}

	public BlockPos getPos() {
		return pos;
	}

	@Override
	public String toString(){
		return "PacketChangeTrainSpeed {" + pos.toString() + ", speed " + newSpeed + "}";
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		newSpeed = buf.readByte();
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		pos = new BlockPos(x, y, z);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeByte(newSpeed);
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
	}

	public static class Handler implements IMessageHandler<TPacketTrainChangeSpeed, IMessage>{
		@Override
		public IMessage onMessage(TPacketTrainChangeSpeed message, MessageContext ctx) {
//			System.out.println("Packet recieved and sent to TE at " + message.pos);
			TileEntityChristmasTreeTrains tectt = (TileEntityChristmasTreeTrains)ctx.getServerHandler().player.world.getTileEntity(message.pos);
			tectt.handleTrainSpeedPacket(message);
			return null;
		}
	}
}
