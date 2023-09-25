# Location Filter Service

Microservice which is responsible for:
- filter locations based on provided search query
- calculate distance between provided source location

## Usage

To get desired result reach following endpoint

```sh
http://domain-name/locations
```

Optionally two parameters can be used:

| GET Parameter | Description |
| ------------- | ----------- |
| loc | it needs to be provided in following way: location=lat,lng, by default it is 0,0 |
| filter | [it accepts string which is used to find proper place names. By default it is empty string ""  | 

### Examples

- With provided coordinates:
```sh
http://domain-name/locations?loc=48.133886,11.545253
```
Note: In that case filter is empty and it will take all places into account

- With provided filter:
```sh
http://domain-name/locations?filter=PAYBACK
```
Note: In that case it will return all places which as PAYBACK keyword within the name

- With provided filter and location:
```sh
http://domain-name/locations?loc=48.133886,11.545253&filter=PAYBACK
```
Note: In that case it will return all places which as PAYBACK keyword within the name and will calculate distance in km from provided location