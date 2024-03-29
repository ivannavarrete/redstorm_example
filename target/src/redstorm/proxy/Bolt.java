package redstorm.proxy;

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.runtime.Helpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import java.util.Map;


public class Bolt extends RubyObject implements IRichBolt {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("require 'java'\n" +
            "\n" +
            "java_import 'backtype.storm.task.OutputCollector'\n" +
            "java_import 'backtype.storm.task.TopologyContext'\n" +
            "java_import 'backtype.storm.topology.IRichBolt'\n" +
            "java_import 'backtype.storm.topology.OutputFieldsDeclarer'\n" +
            "java_import 'backtype.storm.tuple.Tuple'\n" +
            "java_import 'backtype.storm.tuple.Fields'\n" +
            "java_import 'backtype.storm.tuple.Values'\n" +
            "java_import 'java.util.Map'\n" +
            "module Backtype\n" +
            "  java_import 'backtype.storm.Config'\n" +
            "end\n" +
            "\n" +
            "java_package 'redstorm.proxy'\n" +
            "\n" +
            "# the Bolt class is a proxy to the real bolt to avoid having to deal with all the\n" +
            "# Java artifacts when creating a bolt.\n" +
            "#\n" +
            "# The real bolt class implementation must define these methods:\n" +
            "# - prepare(conf, context, collector)\n" +
            "# - execute(tuple)\n" +
            "# - declare_output_fields\n" +
            "#\n" +
            "# and optionnaly:\n" +
            "# - cleanup\n" +
            "#\n" +
            "class Bolt\n" +
            "  java_implements IRichBolt\n" +
            "\n" +
            "  java_signature 'IRichBolt (String base_class_path, String real_bolt_class_name)'\n" +
            "  def initialize(base_class_path, real_bolt_class_name)\n" +
            "    @real_bolt = Object.module_eval(real_bolt_class_name).new\n" +
            "  rescue NameError\n" +
            "    require base_class_path\n" +
            "    @real_bolt = Object.module_eval(real_bolt_class_name).new\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'void prepare(Map, TopologyContext, OutputCollector)'\n" +
            "  def prepare(conf, context, collector)\n" +
            "    @real_bolt.prepare(conf, context, collector)\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'void execute(Tuple)'\n" +
            "  def execute(tuple)\n" +
            "    @real_bolt.execute(tuple)\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'void cleanup()'\n" +
            "  def cleanup\n" +
            "    @real_bolt.cleanup if @real_bolt.respond_to?(:cleanup)\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'void declareOutputFields(OutputFieldsDeclarer)'\n" +
            "  def declareOutputFields(declarer)\n" +
            "    @real_bolt.declare_output_fields(declarer)\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'Map<String, Object> getComponentConfiguration()'\n" +
            "  def getComponentConfiguration\n" +
            "    @real_bolt.get_component_configuration\n" +
            "  end\n" +
            "end\n" +
            "").toString();
        __ruby__.executeScript(source, "/Users/dev/.rvm/gems/jruby-1.7.12/gems/redstorm-0.6.6/lib/red_storm/proxy/bolt.rb");
        RubyClass metaclass = __ruby__.getClass("Bolt");
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: Bolt");
        metaclass.setRubyStaticAllocator(Bolt.class);
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private Bolt(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new Bolt(ruby, metaClass);
    }

    
    public  Bolt(String base_class_path, String real_bolt_class_name) {
        this(__ruby__, __metaclass__);
        IRubyObject ruby_arg_base_class_path = JavaUtil.convertJavaToRuby(__ruby__, base_class_path);
        IRubyObject ruby_arg_real_bolt_class_name = JavaUtil.convertJavaToRuby(__ruby__, real_bolt_class_name);
        Helpers.invoke(__ruby__.getCurrentContext(), this, "initialize", ruby_arg_base_class_path, ruby_arg_real_bolt_class_name);

    }

    
    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        IRubyObject ruby_arg_conf = JavaUtil.convertJavaToRuby(__ruby__, conf);
        IRubyObject ruby_arg_context = JavaUtil.convertJavaToRuby(__ruby__, context);
        IRubyObject ruby_arg_collector = JavaUtil.convertJavaToRuby(__ruby__, collector);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "prepare", ruby_arg_conf, ruby_arg_context, ruby_arg_collector);
        return;

    }

    
    public void execute(Tuple tuple) {
        IRubyObject ruby_arg_tuple = JavaUtil.convertJavaToRuby(__ruby__, tuple);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "execute", ruby_arg_tuple);
        return;

    }

    
    public void cleanup() {

        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "cleanup");
        return;

    }

    
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        IRubyObject ruby_arg_declarer = JavaUtil.convertJavaToRuby(__ruby__, declarer);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "declareOutputFields", ruby_arg_declarer);
        return;

    }

    
    public Map<String, Object> getComponentConfiguration() {

        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "getComponentConfiguration");
        return (Map)ruby_result.toJava(Map.class);

    }

}
