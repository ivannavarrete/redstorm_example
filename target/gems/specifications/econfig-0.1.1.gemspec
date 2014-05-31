# -*- encoding: utf-8 -*-
# stub: econfig 0.1.1 ruby lib

Gem::Specification.new do |s|
  s.name = "econfig"
  s.version = "0.1.1"

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.require_paths = ["lib"]
  s.authors = ["Jonas Nicklas", "Elabs AB"]
  s.date = "2014-04-01"
  s.description = "Flexible configuration for Ruby/Rails applications with a variety of backends"
  s.email = ["jonas.nicklas@gmail.com", "dev@elabs.se"]
  s.homepage = "https://github.com/elabs/econfig"
  s.licenses = ["MIT"]
  s.rubygems_version = "2.2.2"
  s.summary = "Congifure Ruby apps"

  s.installed_by_version = "2.2.2" if s.respond_to? :installed_by_version

  if s.respond_to? :specification_version then
    s.specification_version = 4

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_development_dependency(%q<rspec>, [">= 0"])
      s.add_development_dependency(%q<activerecord>, [">= 0"])
      s.add_development_dependency(%q<sqlite3>, [">= 0"])
      s.add_development_dependency(%q<redis>, [">= 0"])
    else
      s.add_dependency(%q<rspec>, [">= 0"])
      s.add_dependency(%q<activerecord>, [">= 0"])
      s.add_dependency(%q<sqlite3>, [">= 0"])
      s.add_dependency(%q<redis>, [">= 0"])
    end
  else
    s.add_dependency(%q<rspec>, [">= 0"])
    s.add_dependency(%q<activerecord>, [">= 0"])
    s.add_dependency(%q<sqlite3>, [">= 0"])
    s.add_dependency(%q<redis>, [">= 0"])
  end
end
