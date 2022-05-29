package 'httpd' do
action :install
end

file '/var/www/html/index.html' do
	content "DevOps is great!"
	action :create
end

service 'httpd' do
	action [:start,:enable]
end