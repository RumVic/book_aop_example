INSERT INTO book.books (id, name) VALUES
('818a5a4f-513f-49a2-9f0d-ce0a12bf6c7b', 'The Great Gatsby'),
('01237ec2-8773-4cc7-a99e-e24bd9f43fa1', 'To Kill a Mockingbird');

INSERT INTO book.author (id, name, date_of_birth, date_of_death) VALUES
('d64cd842-ae9b-454a-9cd4-7f29da549220', 'F. Scott Fitzgerald', '1896-09-24', '1940-12-21'),
('660f767d-ac62-4582-bf7e-c7385b78b3a7', 'Harper Lee', '1926-04-28', '2016-02-19');

INSERT INTO book.gridfs (id) VALUES
('09ea79fd-cbd6-4235-8a39-bf6ca03d1227'),
('9e4ced69-c387-41c3-b28c-cc15885c2447');

INSERT INTO book.description (id, description_of_story_line, date_of_publication, edition) VALUES
('4f25f73d-3997-4aca-abc6-eb5cf80c51c5', 'A novel set in the Roaring Twenties', '1925-04-10', '1st Edition'),
('81e07844-ba97-42b7-96aa-a6dc1526b740', 'A story about racial injustice', '1960-07-11', '1st Edition');

UPDATE book.books
SET
    author_id = 'd64cd842-ae9b-454a-9cd4-7f29da549220',
    grid_fs_image_id_id = '09ea79fd-cbd6-4235-8a39-bf6ca03d1227',
    description_id = '4f25f73d-3997-4aca-abc6-eb5cf80c51c5'
WHERE id = '818a5a4f-513f-49a2-9f0d-ce0a12bf6c7b';

UPDATE book.books
SET
    author_id = '660f767d-ac62-4582-bf7e-c7385b78b3a7',
    grid_fs_image_id_id = '9e4ced69-c387-41c3-b28c-cc15885c2447',
    description_id = '81e07844-ba97-42b7-96aa-a6dc1526b740'
WHERE id = '01237ec2-8773-4cc7-a99e-e24bd9f43fa1';
--
----1
--UPDATE book.author
--SET
--    book_id = '818a5a4f-513f-49a2-9f0d-ce0a12bf6c7b'
--WHERE id = 'd64cd842-ae9b-454a-9cd4-7f29da549220';
----2
--UPDATE book.author
--SET
--    book_id = '01237ec2-8773-4cc7-a99e-e24bd9f43fa1'
--WHERE id = '660f767d-ac62-4582-bf7e-c7385b78b3a7';
----3
--UPDATE book.description
--SET
--    book_id = '818a5a4f-513f-49a2-9f0d-ce0a12bf6c7b'
--WHERE id = '4f25f73d-3997-4aca-abc6-eb5cf80c51c5';
----4
--UPDATE book.description
--SET
--    book_id = '01237ec2-8773-4cc7-a99e-e24bd9f43fa1'
--WHERE id = '81e07844-ba97-42b7-96aa-a6dc1526b740';
----5
--UPDATE book.gridfs
--SET
--    book_id= '818a5a4f-513f-49a2-9f0d-ce0a12bf6c7b'
--WHERE id = '09ea79fd-cbd6-4235-8a39-bf6ca03d1227';
----6
--UPDATE book.gridfs
--SET
--    book_id= '01237ec2-8773-4cc7-a99e-e24bd9f43fa1'
--WHERE id = '9e4ced69-c387-41c3-b28c-cc15885c2447';
COMMIT;
