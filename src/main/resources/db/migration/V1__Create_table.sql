create table brand (
  "brand_code"     text   not null  primary key,
  "name"           text   not null,
  "own_brand"      boolean not null,
  "url"            text,
  "brand_family_code"  text,
  "media_code"         text,
  "misspelled"         text,
  "country_of_origin"    text
)