require 'red_storm'
require 'examples/dsl/random_sentence_spout'
require 'examples/dsl/split_sentence_bolt'
require 'examples/dsl/word_count_bolt'

module RedStorm
  module Examples
    class WordCountTopology < DSL::Topology
      spout RandomSentenceSpout, :parallelism => 2

      bolt SplitSentenceBolt, :parallelism => 2 do
        source RandomSentenceSpout, :shuffle
      end

      bolt WordCountBolt, :parallelism => 2 do
        source SplitSentenceBolt, :fields => ["word"]
      end

      configure :word_count do |env|
        debug true
        max_task_parallelism 4
        if env == :cluster
          num_workers 6
          max_spout_pending(1000)
        end
      end

      on_submit do |env|
        if env == :local
          sleep(5)
          cluster.shutdown
        end
      end
    end
  end
end