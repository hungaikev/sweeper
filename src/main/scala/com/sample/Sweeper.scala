package com.sample

import akka.actor.{Actor, ActorLogging, Props}



/**
  * Created by hungai on 8/7/17.
  */


object Sweeper {

  def props: Props = Props(new Sweeper)

}


class Sweeper extends Actor with ActorLogging {

  override def preStart(): Unit = log.info("Starting Sweeper Actor")

  override def postStop(): Unit = log.info("Stopping Sweeper Actor")

  override def receive: Receive = {

    case Message => log.info("Sweeping NOW!")

    case _ => log.info("I did not receive the command to start Sweeping")

  }

}
