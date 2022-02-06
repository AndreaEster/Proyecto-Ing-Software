apt-get install git
cd /var/www/html
git clone https://github.com/martulioruiz/martulioruiz.github.io.git
cd "martulioruiz.github.io"
bundle install
bundle exec jekyll serve --host 0.0.0.0