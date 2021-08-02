package de.sfrick.application;

import de.sfrick.udp.f1.packets.PacketType;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.naming.OperationNotSupportedException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class Channel implements Queue<Message> {

   private final PacketType channelName;
   private final Queue<Message> messageQueue;

   private Channel(PacketType channelName, Queue<Message> messageQueue) {
      this.channelName = channelName;
      this.messageQueue = messageQueue;
   }

   public static Channel of(PacketType name) {
      return new Channel(name, new LinkedTransferQueue<Message>());
   }

   public PacketType getChannelName() {
      return channelName;
   }

   @Override
   public boolean add(Message message) {
      return messageQueue.add(message);
   }

   @SneakyThrows
   @Override
   public boolean offer(Message message) {
      throw new OperationNotSupportedException();
   }

   @SneakyThrows
   @Override
   public Message remove() {
      throw new OperationNotSupportedException();
   }

   @Override
   public Message poll() {
      return messageQueue.poll();
   }

   @SneakyThrows
   @Override
   public Message element() {
      return messageQueue.element();
   }

   @Override
   public Message peek() {
      return messageQueue.peek();
   }

   @Override
   public int size() {
      return messageQueue.size();
   }

   @Override
   public boolean isEmpty() {
      return messageQueue.isEmpty();
   }

   @Override
   public boolean contains(Object o) {
      return messageQueue.contains(o);
   }

   @Override
   public Iterator<Message> iterator() {
      return messageQueue.iterator();
   }

   @Override
   public Object[] toArray() {
      return messageQueue.toArray();
   }

   @Override
   public <T> T[] toArray(T[] a) {
      return messageQueue.toArray(a);
   }

   @SneakyThrows
   @Override
   public boolean remove(Object o) {
      throw new OperationNotSupportedException();
   }

   @Override
   public boolean containsAll(Collection<?> c) {
      return messageQueue.containsAll(c);
   }

   @Override
   public boolean addAll(Collection<? extends Message> c) {
      return messageQueue.addAll(c);
   }

   @SneakyThrows
   @Override
   public boolean removeAll(Collection<?> c) {
      throw new OperationNotSupportedException();
   }

   @SneakyThrows
   @Override
   public boolean retainAll(Collection<?> c) {
      throw new OperationNotSupportedException();
   }

   @SneakyThrows
   @Override
   public void clear() {
      throw new OperationNotSupportedException();
   }
}
