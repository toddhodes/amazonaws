#
# Autogenerated by Thrift
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#

from thrift.Thrift import *

from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
try:
  from thrift.protocol import fastbinary
except:
  fastbinary = None


class ThriftHandle:

  thrift_spec = None
  def __init__(self, d=None):
    self.id = None
    if isinstance(d, dict):
      if 'id' in d:
        self.id = d['id']

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == -1:
        if ftype == TType.I64:
          self.id = iprot.readI64();
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('ThriftHandle')
    if self.id != None:
      oprot.writeFieldBegin('id', TType.I64, -1)
      oprot.writeI64(self.id)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def __str__(self):
    return str(self.__dict__)

  def __repr__(self):
    return repr(self.__dict__)

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class Pathname:

  thrift_spec = None
  def __init__(self, d=None):
    self.pathname = None
    if isinstance(d, dict):
      if 'pathname' in d:
        self.pathname = d['pathname']

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == -1:
        if ftype == TType.STRING:
          self.pathname = iprot.readString();
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('Pathname')
    if self.pathname != None:
      oprot.writeFieldBegin('pathname', TType.STRING, -1)
      oprot.writeString(self.pathname)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def __str__(self):
    return str(self.__dict__)

  def __repr__(self):
    return repr(self.__dict__)

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class FileStatus:

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'path', None, None, ), # 1
    (2, TType.I64, 'length', None, None, ), # 2
    (3, TType.BOOL, 'isdir', None, None, ), # 3
    (4, TType.I16, 'block_replication', None, None, ), # 4
    (5, TType.I64, 'blocksize', None, None, ), # 5
    (6, TType.I64, 'modification_time', None, None, ), # 6
    (7, TType.STRING, 'permission', None, None, ), # 7
    (8, TType.STRING, 'owner', None, None, ), # 8
    (9, TType.STRING, 'group', None, None, ), # 9
  )

  def __init__(self, d=None):
    self.path = None
    self.length = None
    self.isdir = None
    self.block_replication = None
    self.blocksize = None
    self.modification_time = None
    self.permission = None
    self.owner = None
    self.group = None
    if isinstance(d, dict):
      if 'path' in d:
        self.path = d['path']
      if 'length' in d:
        self.length = d['length']
      if 'isdir' in d:
        self.isdir = d['isdir']
      if 'block_replication' in d:
        self.block_replication = d['block_replication']
      if 'blocksize' in d:
        self.blocksize = d['blocksize']
      if 'modification_time' in d:
        self.modification_time = d['modification_time']
      if 'permission' in d:
        self.permission = d['permission']
      if 'owner' in d:
        self.owner = d['owner']
      if 'group' in d:
        self.group = d['group']

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.path = iprot.readString();
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.I64:
          self.length = iprot.readI64();
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.BOOL:
          self.isdir = iprot.readBool();
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.I16:
          self.block_replication = iprot.readI16();
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.I64:
          self.blocksize = iprot.readI64();
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.I64:
          self.modification_time = iprot.readI64();
        else:
          iprot.skip(ftype)
      elif fid == 7:
        if ftype == TType.STRING:
          self.permission = iprot.readString();
        else:
          iprot.skip(ftype)
      elif fid == 8:
        if ftype == TType.STRING:
          self.owner = iprot.readString();
        else:
          iprot.skip(ftype)
      elif fid == 9:
        if ftype == TType.STRING:
          self.group = iprot.readString();
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('FileStatus')
    if self.path != None:
      oprot.writeFieldBegin('path', TType.STRING, 1)
      oprot.writeString(self.path)
      oprot.writeFieldEnd()
    if self.length != None:
      oprot.writeFieldBegin('length', TType.I64, 2)
      oprot.writeI64(self.length)
      oprot.writeFieldEnd()
    if self.isdir != None:
      oprot.writeFieldBegin('isdir', TType.BOOL, 3)
      oprot.writeBool(self.isdir)
      oprot.writeFieldEnd()
    if self.block_replication != None:
      oprot.writeFieldBegin('block_replication', TType.I16, 4)
      oprot.writeI16(self.block_replication)
      oprot.writeFieldEnd()
    if self.blocksize != None:
      oprot.writeFieldBegin('blocksize', TType.I64, 5)
      oprot.writeI64(self.blocksize)
      oprot.writeFieldEnd()
    if self.modification_time != None:
      oprot.writeFieldBegin('modification_time', TType.I64, 6)
      oprot.writeI64(self.modification_time)
      oprot.writeFieldEnd()
    if self.permission != None:
      oprot.writeFieldBegin('permission', TType.STRING, 7)
      oprot.writeString(self.permission)
      oprot.writeFieldEnd()
    if self.owner != None:
      oprot.writeFieldBegin('owner', TType.STRING, 8)
      oprot.writeString(self.owner)
      oprot.writeFieldEnd()
    if self.group != None:
      oprot.writeFieldBegin('group', TType.STRING, 9)
      oprot.writeString(self.group)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def __str__(self):
    return str(self.__dict__)

  def __repr__(self):
    return repr(self.__dict__)

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class BlockLocation:

  thrift_spec = (
    None, # 0
    (1, TType.LIST, 'hosts', (TType.STRING,None), None, ), # 1
    (2, TType.LIST, 'names', (TType.STRING,None), None, ), # 2
    (3, TType.I64, 'offset', None, None, ), # 3
    (4, TType.I64, 'length', None, None, ), # 4
  )

  def __init__(self, d=None):
    self.hosts = None
    self.names = None
    self.offset = None
    self.length = None
    if isinstance(d, dict):
      if 'hosts' in d:
        self.hosts = d['hosts']
      if 'names' in d:
        self.names = d['names']
      if 'offset' in d:
        self.offset = d['offset']
      if 'length' in d:
        self.length = d['length']

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.LIST:
          self.hosts = []
          (_etype3, _size0) = iprot.readListBegin()
          for _i4 in xrange(_size0):
            _elem5 = iprot.readString();
            self.hosts.append(_elem5)
          iprot.readListEnd()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.LIST:
          self.names = []
          (_etype9, _size6) = iprot.readListBegin()
          for _i10 in xrange(_size6):
            _elem11 = iprot.readString();
            self.names.append(_elem11)
          iprot.readListEnd()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.I64:
          self.offset = iprot.readI64();
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.I64:
          self.length = iprot.readI64();
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('BlockLocation')
    if self.hosts != None:
      oprot.writeFieldBegin('hosts', TType.LIST, 1)
      oprot.writeListBegin(TType.STRING, len(self.hosts))
      for iter12 in self.hosts:
        oprot.writeString(iter12)
      oprot.writeListEnd()
      oprot.writeFieldEnd()
    if self.names != None:
      oprot.writeFieldBegin('names', TType.LIST, 2)
      oprot.writeListBegin(TType.STRING, len(self.names))
      for iter13 in self.names:
        oprot.writeString(iter13)
      oprot.writeListEnd()
      oprot.writeFieldEnd()
    if self.offset != None:
      oprot.writeFieldBegin('offset', TType.I64, 3)
      oprot.writeI64(self.offset)
      oprot.writeFieldEnd()
    if self.length != None:
      oprot.writeFieldBegin('length', TType.I64, 4)
      oprot.writeI64(self.length)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def __str__(self):
    return str(self.__dict__)

  def __repr__(self):
    return repr(self.__dict__)

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class MalformedInputException(Exception):

  thrift_spec = None
  def __init__(self, d=None):
    self.message = None
    if isinstance(d, dict):
      if 'message' in d:
        self.message = d['message']

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == -1:
        if ftype == TType.STRING:
          self.message = iprot.readString();
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('MalformedInputException')
    if self.message != None:
      oprot.writeFieldBegin('message', TType.STRING, -1)
      oprot.writeString(self.message)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def __str__(self):
    return str(self.__dict__)

  def __repr__(self):
    return repr(self.__dict__)

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class ThriftIOException(Exception):

  thrift_spec = None
  def __init__(self, d=None):
    self.message = None
    if isinstance(d, dict):
      if 'message' in d:
        self.message = d['message']

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == -1:
        if ftype == TType.STRING:
          self.message = iprot.readString();
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('ThriftIOException')
    if self.message != None:
      oprot.writeFieldBegin('message', TType.STRING, -1)
      oprot.writeString(self.message)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def __str__(self):
    return str(self.__dict__)

  def __repr__(self):
    return repr(self.__dict__)

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

