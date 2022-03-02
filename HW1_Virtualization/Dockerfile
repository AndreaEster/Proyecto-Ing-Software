FROM php:8.0.12-apache
ENV ACCEPT_EULA=Y

RUN apt-get update \
&& apt-get install ruby-full build-essential zlib1g-dev -y \
&& echo '# Install Ruby Gems to ~/gems' >> ~/.bashrc \
&& echo 'export GEM_HOME="$HOME/gems"' >> ~/.bashrc \
&& echo 'export PATH="$HOME/gems/bin:$PATH"' >> ~/.bashrc \
&& /bin/sh ~/.bashrc \
&& gem install jekyll bundler




   

