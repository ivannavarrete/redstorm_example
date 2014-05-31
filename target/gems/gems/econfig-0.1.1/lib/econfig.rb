require "econfig/version"
require "econfig/memory"
require "econfig/yaml"
require "econfig/env"
require "econfig/configuration"
require "econfig/shortcut"

module Econfig
  class NotFound < StandardError; end
  class UninitializedError < StandardError; end

  class << self
    attr_accessor :root, :env, :instance

    def use_database
      require "econfig/active_record"
      Econfig.instance.backends << Econfig::ActiveRecord.new
    end

    def use_redis(redis)
      require "econfig/redis"
      Econfig.instance.backends << Econfig::Redis.new(redis)
    end

    def init
      Econfig.instance.backends.each do |backend|
        backend.init if backend.respond_to?(:init)
      end
    end
  end
end

Econfig.instance = Econfig::Configuration.new
Econfig.instance.backends << Econfig::ENV.new
Econfig.instance.backends << Econfig::YAML.new
