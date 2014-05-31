require "red_storm"

class HelloWorldSpout < RedStorm::DSL::Spout
  def on_init
    @words = ["hello", "world"]
  end

  def on_send
    @words.shift unless @words.empty?
  end
end

class HelloWorldBolt < RedStorm::DSL::Bolt
  on_receive emit: false

  def on_receive(tuple)
    log.info tuple[0]
  end
end

class HelloWorldTopology < RedStorm::DSL::Topology
  spout HelloWorldSpout do
    output_fields :word
  end

  bolt HelloWorldBolt do
    source HelloWorldSpout, :global
  end
end
