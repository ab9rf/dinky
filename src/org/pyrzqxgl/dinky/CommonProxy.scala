package org.pyrzqxgl.dinky

trait CommonProxy {
  def preInit() = {}
  def init() = {}
}

class ClientProxy extends CommonProxy {
  override def preInit() = {
    Blocks.registerModels()
  }
}

class ServerProxy extends CommonProxy {
}
