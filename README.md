# Salonsql

##### _{Salon and spa management software}, {August 28, 2015}_
 
#### By _**{Annie Brown}**_

## Description
 
_{Salonsql is a lightweight, open source, and extensible salon management and administration application for use as a standalone or on the web.}_


## Setup

* Salonsql relies on the open source database PostgreSQL.  
To install PostgreSQL, consult user documentation for your distribution at <http://www.postgresql.org/docs/manuals>. 

In PSQL:
CREATE DATABASE hair_salon;
CREATE TABLE clients (id serial PRIMARY KEY, name varchar);
CREATE TABLE stylists (id serial PRIMARY KEY, description varchar);

## Technologies Used

_{Java SDK 7, Spark Framework, and Postgresql. Build automation and unit testing managed by Gradle}
 
### Legal

**

Copyright (c) 2015 **_{Annie Brown}_**

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE
