package me.kk47.dct.network;

import io.netty.buffer.ByteBuf;
import me.kk47.dct.te.TileEntityChristmasTreeTrains;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class TPacketTrainChangeDirection implements IMessage{
	private boolean forwards;
	private BlockPos pos;

	public TPacketTrainChangeDirection() {
		forwards = true;
		pos = new BlockPos(0, 0, 0);
	}

	public TPacketTrainChangeDirection(boolean forwards, BlockPos pos) {
		this.forwards = forwards;
		this.pos = pos;
	}

	public boolean getNewDirection() {
		return forwards;
	}

	public BlockPos getPos() {
		return pos;
	}

	@Override
	public String toString(){
		return "PacketChangeTrainDirection {" + pos.toString() + ", direction " + forwards + "}";
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		forwards = buf.readBoolean();
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		pos = new BlockPos(x, y, z);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(forwards);
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
	}

	public static class HandlePacketChangeTrainDirection implements IMessageHandler<TPacketTrainChangeDirection, IMessage>{
		@Override
		public IMessage onMessage(TPacketTrainChangeDirection message, MessageContext ctx){
			TileEntityChristmasTreeTrains tectt = (TileEntityChristmasTreeTrains) ctx.getServerHandler().player.world.getTileEntity(message.pos); // or Minecraft.getMinecraft() on the client
			tectt.handleTrainDirectionPacket(message);
			return null;
		}

	}
}
