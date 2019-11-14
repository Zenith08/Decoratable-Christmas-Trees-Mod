package me.kk47.dct.te;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.client.models.ModelChristmasTree;
import me.kk47.modeltrains.api.IItemModelTrack;
import me.kk47.modeltrains.api.IItemTrain;
import me.kk47.modeltrains.api.ITileEntityTrackContainer;
import me.kk47.modeltrains.api.ITileEntityTrainContainer;
import me.kk47.modeltrains.blocks.ModBlocks;
import me.kk47.modeltrains.items.ModItems;
import me.kk47.modeltrains.math.MathHelper;
import me.kk47.modeltrains.math.Position3F;
import me.kk47.modeltrains.tileentity.TileEntityTrainController;
import me.kk47.modeltrains.train.RollingStock;
import me.kk47.ueri.UERIRenderable;
import me.kk47.ueri.UERITechne;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;

public class TileEntityChristmasTreeTrains extends TileEntityChristmasTreeNormal implements ITileEntityTrackContainer, ITileEntityTrainContainer{

	public TileEntityChristmasTreeTrains() {
		super();
		firstTick = true; 
		for(int i = 0; i < trains.length; i++){
			trains[i] = new RollingStock(new Position3F(), this);
		}
	}

	@Override
	public boolean supportsTrains() {
		return true;
	}

	@Override
	public int getSizeInventory() {
		return 4;
	}

	public static final int BLOCK_OFFSET = 32;

	//The static stuff controlls the basic inventory of tracks and will always be the same.
	public static final ItemStack TRACK_NORTH = new ItemStack(ModItems.trackStraight, 1, 0);
	public static final ItemStack TRACK_EAST = new ItemStack(ModItems.trackStraight, 1, 1);

	public static ItemStack[][] TRACKS = new ItemStack[][]{
		{new ItemStack(ModItems.trackCorner, 1, 2), new ItemStack(ModItems.trackStraight, 1, 0), new ItemStack(ModItems.trackStraight, 1, 0), new ItemStack(ModItems.trackCorner, 1, 3)},
		{new ItemStack(ModItems.trackStraight, 1, 1), null, null, new ItemStack(ModItems.trackStraight, 1, 1)},
		{new ItemStack(ModItems.trackStraight, 1, 1), null, null, new ItemStack(ModItems.trackStraight, 1, 1)},
		{new ItemStack(ModItems.trackCorner, 1, 1), new ItemStack(ModItems.trackStraight, 1, 0), new ItemStack(ModItems.trackStraight, 1, 0), new ItemStack(ModItems.trackCorner, 1, 0)}
	};

	public static Position3F[] trainStartPoints = new Position3F[]{
			new Position3F(BLOCK_OFFSET*4 + 0.5F-1, BLOCK_OFFSET*4 + 3.5F, 0.0F), new Position3F(BLOCK_OFFSET*4 + 0.5F-2, BLOCK_OFFSET*4 + 3.5F, 270.0F), 
			new Position3F(BLOCK_OFFSET*4 + 0.5F-3, BLOCK_OFFSET*4 + 3.5F, 270.0F), new Position3F(BLOCK_OFFSET*4 + 0.5F-4, BLOCK_OFFSET*4 + 3.5F, 270.0F)
	};

	//The static stuff ends here -------------------------------------------------------------

	private RollingStock[] trains = new RollingStock[4]; //Each train is initalized in initTrain() called by firstTick()

	/**Is the train going backwards? Yes? then this is false
	 * Field ID 1*/
	private boolean forwards = true;
	/**Train's Speed - get it with speeds[this value]
	 * Field ID 0*/
	private byte speed = 1;

	/**The position is logical 0, 0*/
	private BlockPos startPos;

	/**It's in the name*/
	private boolean firstTick;

	@Override
	public int getDirection(){
		if(forwards)
			return 1;
		return -1;
	}

	@Override
	public boolean getDirectionValue(){
		return forwards;
	}

	@Override
	public float getSpeed(){
		return TileEntityTrainController.speeds[speed]*getDirection();
	}

	@Override
	public byte getSpeedValue(){
		return speed;
	}

	@Override
	public void setSpeed(byte speed){
		this.speed = speed;
	}

	@Override
	public RollingStock[] getTrains(){
		return trains;
	}

	@Override
	public boolean isTrack(Position3F pos){
		try{
			int x = 0;
			float spareX = pos.getX();
			while(spareX>=4){
				spareX-=4;
				x++;
			}
			int y = 0;
			float spareY = pos.getY();
			while(spareY>=4){
				spareY-=4;
				y++;
			}
			BlockPos check = startPos;
			check = check.east((x+1));
			check = check.south(y);
			return ((ITileEntityTrackContainer)world.getTileEntity(check)).getInventory()[MathHelper.floorFloat(spareX)][MathHelper.floorFloat(spareY)] != null 
					&& ((ITileEntityTrackContainer)world.getTileEntity(check)).getInventory()[MathHelper.floorFloat(spareX)][MathHelper.floorFloat(spareY)].getItem() instanceof IItemModelTrack;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean isTrackBlock(Position3F pos){
		try{
			int x = 0;
			float rand = pos.getX();
			while(rand>=4){
				rand-=4;
				x++;
			}
			int y = 0;
			rand = pos.getY();
			while(rand>=4){
				rand-=4;
				y++;
			}
			if(world.getTileEntity(startPos.east(x+1).south(y)) != null && world.getTileEntity(startPos.east(x+1).south(y)).getBlockType().getUnlocalizedName().equalsIgnoreCase(ModBlocks.trackBed.getUnlocalizedName())){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public ITileEntityTrackContainer getTrackBedAt(Position3F pos){
		if(!isTrack(pos)) return null;

		int x = 0;
		float rand = pos.getX();
		while(rand>=4){
			rand-=4;
			x++;
		}
		int y = 0;
		rand = pos.getY();
		while(rand>=4){
			rand-=4;
			y++;
		}

		return (ITileEntityTrackContainer) world.getTileEntity(startPos.east(x+1).south(y));
	}

	@Override
	public ItemStack getTrackAt(Position3F pos){
		if(!isTrack(pos)) return null;

		int x = 0;
		float spareX = pos.getX();
		while(spareX>=4){
			spareX-=4;
			x++;
		}
		int y = 0;
		float spareY = pos.getY();
		while(spareY>=4){
			spareY-=4;
			y++;
		}
		return ((ITileEntityTrackContainer)world.getTileEntity(startPos.east(x+1).south(y))).getInventory()[MathHelper.floorFloat(spareX)][MathHelper.floorFloat(spareY)];
	}

	private Position3F getStartDirections(int index){
		return trainStartPoints[index].clone();
	}

	private void initTrains(){
		for(int i = 0; i < trains.length; i++){
			trains[i] = new RollingStock(getStartDirections(i), this);
			/*			if(i == 0){
//				trains[i].setTrainItem(ModItems.toyTrain); //Temp Init
			}else{
//				trains[i].setTrainItem(ModItems.dummyTrain); //Temp Init
			}*/
		}
	}

	private void firstTick(){
		//These fields MUST BE CALCULATED before anything else happens
		startPos = pos.west(BLOCK_OFFSET).north(BLOCK_OFFSET);
		//Now everything else can happen
		initTrains();
		firstTick = false;
	}

	@Override
	public void update() {
		super.update();
		//This should always happen first in update() to allow basic data setting
		if(firstTick){
			firstTick();
		}

		//Give each train an update tick and set inventory item
		if(!hasValidLoco()){
			speed = 0;
		}else{

		}

		boolean hasTrainWithItem = false;
		for(int i = 0; i < trains.length; i++){
			RollingStock r = trains[i];

			if(getStackInSlot(7-i) !=null && getStackInSlot(7-i).getItem() instanceof IItemTrain){
				r.setTrainItem((IItemTrain) getStackInSlot(7-i).getItem());
				hasTrainWithItem = true;
			}else{
				r.setTrainItem(null);
			}

			r.setSpeed(getSpeed());
			r.update();
		}

		if(!hasTrainWithItem)
			initTrains();

		world.notifyBlockUpdate(pos, ModBlocks.trackBed.getDefaultState(), ModBlocks.trackBed.getDefaultState(), 1);
		this.markDirty();
	}

	public boolean hasTrain(){
		boolean out = false;
		for(int i = 0; i < 4; i++){
			if(getStackInSlot(7-i) != null)
				out = true;
		}
		return out;
	}

	//Packet Handling ----------------------------------------------------
	/*	TPacketChangeTrainSpeed lastPacket;
	public synchronized void handleTrainSpeedPacket(TPacketChangeTrainSpeed packet){
		lastPacket = packet;
//		System.out.println("Packet recieved and handled");
		((WorldServer) world).addScheduledTask(new Runnable() {
			@Override
			public void run() {
				if(hasValidLoco()){
//					System.out.println("Set field based on packet");
					setField(0, lastPacket.getNewSpeed());
				}
			}
		});
	}

		TPacketChangeTrainDirection lastDirPacket;
	public synchronized void handleTrainDirectionPacket(TPacketChangeTrainDirection message) {
		lastDirPacket = message;
		((WorldServer) world).addScheduledTask(new Runnable() {
			@Override
			public void run() {
				if(speed == 0){
					if(lastDirPacket.getNewDirection()){
						setField(1, 1);
					}else{
						setField(1, 0);
					}
				}
			}
		});
	}*/

	/* (non-Javadoc)
	 * @see me.kk47.modeltrains.tileentity.ITileEntityTrainContainer#hasValidLoco()
	 */
	@Override
	public boolean hasValidLoco(){
		boolean out = false;
		for(RollingStock r : trains){
			if(r.getTrainItem() != null){
				if(r.getTrainItem().getTrainType().isLocomotive()){
					out = true;
				}
			}
		}
		return out;
	}

	//Default syncing ----------------------------------------------------
	//Called on Server side
	@Nullable
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		//		System.out.println("<Server> sending update packet");
		return super.getUpdatePacket();
	}

	//Server
	public NBTTagCompound getUpdateTag(){
		//		System.out.println("<Server> get update tag");
		//		NBTTagCompound syncData = new NBTTagCompound();
		NBTTagCompound syncData = super.getUpdateTag();
		this.writeSyncableDataToNBT(syncData);
		return syncData;
	}

	//Client
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		//		System.out.println("<Client> recieved packet");
		super.onDataPacket(net, pkt);
		readSyncableDataFromNBT(pkt.getNbtCompound());
	}

	public void writeSyncableDataToNBT(NBTTagCompound nbt){
		super.writeSyncableDataToNBT(nbt);
		if(trains[0] != null){
			for(int i = 0; i < trains.length; i++){
				nbt.setFloat("train" + i + "x", trains[i].getPos().getX());
				nbt.setFloat("train" + i + "y", trains[i].getPos().getY());
				nbt.setFloat("train" + i + "yaw", trains[i].getPos().getYaw());
			}
		}
		nbt.setByte("speed", speed);
		nbt.setBoolean("forward", forwards);

		//Writes the inventory
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			if (this.getStackInSlot(i) != null) {
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		nbt.setTag("Items", list);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if(firstTick)
			this.writeSyncableDataToNBT(nbt);

		return nbt;
	}

	public void readSyncableDataFromNBT(NBTTagCompound nbt){
		super.readSyncableDataFromNBT(nbt);
		forwards = nbt.getBoolean("forward");
		speed = nbt.getByte("speed");

		for(int i = 0; i < trains.length; i++){
			trains[i].setPos(new Position3F(nbt.getFloat("train" + i + "x"), nbt.getFloat("train" + i + "y"), nbt.getFloat("train" + i + "yaw")));
		}

		//Reads the inventory
		NBTTagList list = nbt.getTagList("Items", 10);
		for (int i = 0; i < list.tagCount(); ++i) {
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			this.setInventorySlotContents(slot, new ItemStack(stackTag));
			//this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if(!firstTick)
			this.readSyncableDataFromNBT(nbt);
	}

	/**Gets the TRACK inventory
	 * For the train inventory use the getTrains() method*/
	@Override
	public ItemStack[][] getInventory() {
		return TRACKS;
	}

	@Override
	public int getField(int id) {
		switch(id){
		case 0:
			return speed;
		case 1:
			if(forwards)
				return 1;
			return 0;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		if(id == 0){
			speed = (byte)value;
		}else if(id == 1){
			if(value == 0){
				forwards = true;
			}else{
				forwards = false;
			}
		}
	}

	@Override
	public int getFieldCount() {
		return 2;
	}
}
